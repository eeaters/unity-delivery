package io.eeaters.delivery.shunfeng;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.CallBackContext;
import io.eeaters.delivery.core.CallBackResultGenerate;
import io.eeaters.delivery.core.ChannelClient;
import io.eeaters.delivery.core.client.HttpClient;
import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.exception.DeliveryRemoteException;
import io.eeaters.delivery.core.request.*;
import io.eeaters.delivery.core.response.*;
import io.eeaters.delivery.core.util.JsonUtils;
import io.eeaters.delivery.core.util.MapUtils;
import io.eeaters.delivery.core.util.UnitUtils;
import io.eeaters.delivery.shunfeng.convert.*;
import io.eeaters.delivery.shunfeng.enums.SFDeliveryStatus;
import io.eeaters.delivery.shunfeng.request.*;
import io.eeaters.delivery.shunfeng.response.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static io.eeaters.delivery.core.util.UnitUtils.secondToLocalDateTime;
import static io.eeaters.delivery.shunfeng.SFUrlToRespTypeEnum.*;

public class SFClient implements ChannelClient {

    private static final Map<String, Object> successResult = MapUtils.initDoubleEntryMap("error_code", 0,
            "error_msg", "success");
    private static final Map<String, Object> failureResult = MapUtils.initDoubleEntryMap("error_code", -1,
            "error_msg", "failure");

    private static final CallBackResultGenerate resultGenerate = verify -> verify ? successResult : failureResult;


    HttpClient httpClient = new HttpClient.Default();

    @Override
    public PreDeliveryResp createPreDelivery(Account account,
                                             CreateDeliveryReq createDeliveryReq) {
        SFPreDeliveryReq req = SFPreDeliveryReqConverter.convert(createDeliveryReq, account);
        SFBaseResponse<SFPreDeliveryResp> response = handlerInternal(PRE_ORDER, req, account);

        assert response != null;
        return Optional.of(response)
                .filter(SFBaseResponse::isSuccess)
                .map(resp -> {
                    PreDeliveryResp result = new PreDeliveryResp();
                    result.setTotalPrice(resp.getResult().getTotalPrice());
                    result.setExpectTime(UnitUtils.secondToLocalDateTime(resp.getResult().getExpectTime()));
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getErrorCode(), response.getErrorMsg()));
    }


    @Override
    public CreateDeliveryResp createDelivery(Account account, CreateDeliveryReq createDeliveryReq) {
        SFCreateDeliveryReq params = SFCreateDeliveryReqConverter.convert(createDeliveryReq, account);
        SFBaseResponse<SFCreateDeliveryResp> response = handlerInternal(CREATE_ORDER, params, account);

        assert response != null;
        return Optional.of(response)
                .filter(SFBaseResponse::isSuccess)
                .map(resp -> {
                    CreateDeliveryResp result = new CreateDeliveryResp();
                    result.setTotalPrice(response.getResult().getTotalPrice());
                    result.setPushTime(secondToLocalDateTime(response.getResult().getPushTime()));
                    result.setChannelOrderId(response.getResult().getSfOrderId());
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getErrorCode(), response.getErrorMsg()));
    }

    @Override
    public CancelDeliveryResp cancelDelivery(Account account, CancelDeliveryReq cancelDeliveryReq) {
        SFCancelDeliveryReq params = SFCancelDeliveryReqConverter.convert(cancelDeliveryReq, account);
        SFBaseResponse<SFCancelDeliveryResp> response = handlerInternal(CANCEL_ORDER, params, account);

        assert response != null;
        return Optional.of(response)
                .filter(SFBaseResponse::isSuccess)
                .map(resp -> {
                    CancelDeliveryResp result = new CancelDeliveryResp();
                    result.setDeductionFee(UnitUtils.fenToYuan(response.getResult()
                            .getDeductionDetail()
                            .getDeductionFee()
                    ));
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getErrorCode(), response.getErrorMsg()));
    }

    @Override
    public QueryDeliveryInfoResp queryDeliveryInfo(Account account, QueryDeliveryInfoReq queryDeliveryInfoReq) {
        SFQueryDeliveryInfoReq params = SFQueryDeliveryReqConverter.convert(queryDeliveryInfoReq, account);
        SFBaseResponse<SFQueryDeliveryResp> response = handlerInternal(QUERY_ORDER, params, account);
        assert response != null;

        return Optional.of(response)
                .filter(SFBaseResponse::isSuccess)
                .map(resp -> {
                    QueryDeliveryInfoResp result = new QueryDeliveryInfoResp();
                    result.setRiderName(response.getResult().getRiderName());
                    result.setRiderPhone(response.getResult().getRiderPhone());
                    result.setStatusEnum(SFDeliveryStatus.of(resp.getResult().getOrderStatus()).getStatusEnum());
                    result.setContent(response.getResult().getStatusDesc());
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getErrorCode(), response.getErrorMsg()));
    }

    @Override
    public QueryRiderPositionResp queryRiderPosition(Account account, QueryRiderPositionReq queryRiderPositionReq) {
        SFQueryRiderPositionReq params = SFQueryRiderPositionReqConverter.convert(account, queryRiderPositionReq);
        SFBaseResponse<SFQueryDeliveryResp> response = handlerInternal(QUERY_RIDER, params, account);

        assert response != null;
        return Optional.of(response)
                .filter(SFBaseResponse::isSuccess)
                .map(resp -> {
                    QueryRiderPositionResp result = new QueryRiderPositionResp();
                    return result;
                }).orElseThrow(() -> new DeliveryRemoteException(response.getErrorCode(), response.getErrorMsg()));

    }

    @Override
    public void callBackHandler(CallBackContext callBackContext) {
        CallBackDeliveryReq deliveryReq = SFToCallBackDeliveryReqConverter.convert(callBackContext.getCallbackStr());
        Account account = callBackContext.getAccountLookUp()
                .getByDeliveryCode(supportChannel(), deliveryReq.getDeliveryCode());
        String sign = SignGenerate.generateSign(callBackContext.getCallbackStr(),
                account.getAppId(), account.getAppKey());

        callBackContext.init(Objects.equals(sign, callBackContext.getSign()), resultGenerate, deliveryReq);
    }

    @Override
    public DeliveryChannelEnum supportChannel() {
        return DeliveryChannelEnum.SF;
    }

    private <T> SFBaseResponse<T> handlerInternal(SFUrlToRespTypeEnum typeEnum, Object param, Account account) {
        String postData = JsonUtils.writeValueToString(param);

        String sign = SignGenerate.generateSign(postData, account.getAppId(), account.getAppKey());
        String url = SFConstants.URL_PREFIX + typeEnum.getUrl() + "?sign=" + sign;

        String response = httpClient.post(url, param);
        return JsonUtils.readValue(response, typeEnum.getResponseType());
    }
}
