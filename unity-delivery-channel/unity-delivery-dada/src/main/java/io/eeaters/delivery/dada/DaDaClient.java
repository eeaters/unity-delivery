package io.eeaters.delivery.dada;

import io.eeaters.delivery.core.CallBackHandler;
import io.eeaters.delivery.core.cache.ExpireCache;
import io.eeaters.delivery.core.cache.LocalCacheExpireCache;
import io.eeaters.delivery.core.client.HttpClient;
import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.enums.EnvEnum;
import io.eeaters.delivery.core.exception.DeliveryRemoteException;
import io.eeaters.delivery.core.request.*;
import io.eeaters.delivery.core.response.*;
import io.eeaters.delivery.core.util.CollectionUtils;
import io.eeaters.delivery.core.util.JsonUtils;
import io.eeaters.delivery.core.util.ServiceLoaderUtils;
import io.eeaters.delivery.core.util.UnitUtils;
import io.eeaters.delivery.dada.convert.DaDaCancelDeliveryReqConverter;
import io.eeaters.delivery.dada.convert.DaDaCreateDeliveryReqConverter;
import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.ChannelClient;
import io.eeaters.delivery.dada.enums.DaDaDeliveryStatus;
import io.eeaters.delivery.dada.request.*;
import io.eeaters.delivery.dada.response.*;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.eeaters.delivery.dada.DaDaConstants.PROD_URL_PREFIX;
import static io.eeaters.delivery.dada.DaDaConstants.QA_URL_PREFIX;
import static io.eeaters.delivery.dada.DaDaUrlToRespTypeEnum.*;

@Slf4j
public class DaDaClient implements ChannelClient {

    final HttpClient httpClient = new HttpClient.Default();

    ExpireCache<String> expireCache = ServiceLoaderUtils.loadFirstSPI(ExpireCache.class)
            .orElse(new LocalCacheExpireCache<String>());

    private static final CallBackHandler resultGenerate = new DaDaCallBackHandler();



    @Override
    public PreDeliveryResp createPreDelivery(Account account, CreateDeliveryReq createDeliveryReq) {
        DaDaCreateDeliveryReq deliveryReq = DaDaCreateDeliveryReqConverter.convert(createDeliveryReq, account);
        DaDaBaseResponse<DaDaPreDeliveryResp> response = handlerInternal(PRE_ORDER, deliveryReq, account);

        return Optional.of(response)
                .filter(DaDaBaseResponse::isSuccess)
                .map(resp -> {
                    PreDeliveryResp result = new PreDeliveryResp();
                    result.setTotalPrice(UnitUtils.yuanToFen(resp.getResult().getFee()));
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getCode(), response.getMsg()));
    }

    @Override
    public CreateDeliveryResp createDelivery(Account account, CreateDeliveryReq createDeliveryReq) {
        DaDaCreateDeliveryReq deliveryReq = DaDaCreateDeliveryReqConverter.convert(createDeliveryReq, account);
        DaDaBaseResponse<DaDaCreateDeliveryResp> response = handlerInternal(CREATE_ORDER, deliveryReq, account);
        assert response != null;

        return Optional.of(response)
                .filter(DaDaBaseResponse::isSuccess)
                .map(resp -> {
                    CreateDeliveryResp result = new CreateDeliveryResp();
                    result.setPushTime(LocalDateTime.now());
                    result.setTotalPrice(UnitUtils.yuanToFen(resp.getResult().getFee()));
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getCode(), response.getMsg()));
    }

    @Override
    public CancelDeliveryResp cancelDelivery(Account account, CancelDeliveryReq cancelDeliveryReq) {
        DaDaCancelDeliveryReq cancelRequest = DaDaCancelDeliveryReqConverter.convert(cancelDeliveryReq);
        DaDaBaseResponse<DaDaCancelDeliveryResp> response = handlerInternal(CANCEL_ORDER, cancelRequest, account);
        assert response != null;

        return Optional.of(response)
                .filter(DaDaBaseResponse::isSuccess)
                .map(resp -> {
                    CancelDeliveryResp result = new CancelDeliveryResp();
                    result.setDeductionFee(response.getResult().getDeductFee());
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getCode(), response.getMsg()));
    }

    @Override
    public QueryDeliveryInfoResp queryDeliveryInfo(Account account, QueryDeliveryInfoReq queryDeliveryInfoReq) {
        DaDaQueryDeliveryInfoReq params = new DaDaQueryDeliveryInfoReq();
        params.setOrderId(queryDeliveryInfoReq.getDeliveryCode());
        DaDaBaseResponse<DaDaQueryDeliveryResp> response = handlerInternal(QUERY_ORDER, params, account);
        assert response != null;

        return Optional.of(response)
                .filter(DaDaBaseResponse::isSuccess)
                .map(resp -> {
                    QueryDeliveryInfoResp result = new QueryDeliveryInfoResp();
                    result.setContent(response.getResult().getStatusMsg());
                    result.setRiderName(response.getResult().getTransporterName());
                    result.setRiderPhone(response.getResult().getTransporterPhone());
                    result.setStatusEnum(DaDaDeliveryStatus.of(response.getResult().getStatusCode()).getStatusEnum());
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getCode(), response.getMsg()));
    }

    @Override
    public QueryRiderPositionResp queryRiderPosition(Account account, QueryRiderPositionReq queryRiderPositionReq) {
        DaDaQueryRiderPositionReq req = new DaDaQueryRiderPositionReq();
        req.setOrderIds(CollectionUtils.ofList(queryRiderPositionReq.getDeliveryCode()));
        DaDaBaseResponse<List<DaDaQueryRiderPositionResp>> response = handlerInternal(QUERY_RIDER, req, account);
        assert response != null;
        if (!response.isSuccess()) {
            throw new DeliveryRemoteException(response.getCode(), response.getMsg());
        }
        QueryRiderPositionResp result = new QueryRiderPositionResp();
        response.getResult()
                .stream()
                .filter(res -> res.getOrderId().equals(queryRiderPositionReq.getDeliveryCode()))
                .findFirst()
                .ifPresent(re -> {
                    result.setRiderName(re.getTransporterName());
                    result.setRiderPhone(re.getTransporterPhone());
                    Optional.ofNullable(re.getTransporterLat()).map(Double::valueOf).ifPresent(result::setRiderLat);
                    Optional.ofNullable(re.getTransporterLng()).map(Double::valueOf).ifPresent(result::setRiderLng);
                });
        return result;
    }



    @Override
    public DeliveryChannelEnum supportChannel() {
        return DeliveryChannelEnum.DADA;
    }

    //cityCode是达达的元数据，和account没有强关联，具之前问过达达的开发伙伴，这个变化基本在达达要支持新的区域进行配送时
    public String cityNameToCityCode(Account account, String cityName) {
        String cityCode = expireCache.get(cityName);
        if (cityCode == null || cityCode.isEmpty()) {
            //初始化
            Map<String, Object> param = DaDaSignGenerate.generateParams(account, "{}");
            DaDaBaseResponse<List<DaDaCityCodeResp>> resp = handlerInternal(CITY_CODE, param, account);
            assert resp != null;
            if (resp.isSuccess()) {
                resp.getResult().forEach(cityCodeResp ->
                        expireCache.put(cityCodeResp.getCityName(),
                        cityCodeResp.getCityCode(),
                        Duration.ofDays(1L).toMillis()
                ));
            }else{
                log.warn("查询达达城市code报错，报错code:{} , errorMessage: {}", resp.getCode(), resp.getMsg());
            }
        }
        return expireCache.get(cityName);
    }

    private <T> DaDaBaseResponse<T> handlerInternal(DaDaUrlToRespTypeEnum typeEnum, Object param, Account account) {
        Map<String, Object> params = DaDaSignGenerate.generateParams(account, JsonUtils.writeValueToString(param));
        String prefix = account.getEnv() == EnvEnum.PROD ? PROD_URL_PREFIX : QA_URL_PREFIX;
        String response = httpClient.post(prefix+ typeEnum.getUrl(), params);
        return JsonUtils.readValue(response, typeEnum.getResponseType());
    }

}
