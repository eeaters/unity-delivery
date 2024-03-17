package io.eeaters.delivery.shunfeng;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.CallBackHandler;
import io.eeaters.delivery.core.DeliveryRelateAccountLookUp;
import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.request.CallBackDeliveryReq;
import io.eeaters.delivery.core.util.JsonUtils;
import io.eeaters.delivery.core.util.MapUtils;
import io.eeaters.delivery.shunfeng.convert.SFToCallBackDeliveryReqConverter;
import io.eeaters.delivery.shunfeng.request.SFCallbackStatusReq;

import java.util.Map;
import java.util.Objects;

public class SFCallBackHandler implements CallBackHandler {
    static final Map<String, Object> success = MapUtils.initDoubleEntryMap(
            "error_code", 0,
            "error_msg", "success"
    );

    static final Map<String, Object> failure = MapUtils.initDoubleEntryMap(
            "error_code", -1,
            "error_msg", "failure"
    );

    @Override
    public CallBackDeliveryReq handlerCallBack(String callBackStr,
                                               String sign,
                                               DeliveryRelateAccountLookUp accountLookUp) {
        SFCallbackStatusReq callBackReq = JsonUtils.readValue(callBackStr, SFCallbackStatusReq.class);

        Account account = accountLookUp.getByDeliveryCode(supportChannel(), callBackReq.getShopOrderId());
        String generateSign = SignGenerate.generateSign(callBackStr, account.getAppId(), account.getAppKey());

        CallBackDeliveryReq deliveryReq = SFToCallBackDeliveryReqConverter.convert(callBackReq);
        deliveryReq.setSignVerify(Objects.equals(sign, generateSign));
        return deliveryReq;
    }


    @Override
    public Object generate(Boolean verify) {
        return verify ? success : failure;
    }


    @Override
    public DeliveryChannelEnum supportChannel() {
        return DeliveryChannelEnum.SF;
    }


}
