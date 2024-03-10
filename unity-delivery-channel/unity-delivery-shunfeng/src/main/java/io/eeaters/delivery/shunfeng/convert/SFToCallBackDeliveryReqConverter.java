package io.eeaters.delivery.shunfeng.convert;

import io.eeaters.delivery.core.request.CallBackDeliveryReq;

public interface SFToCallBackDeliveryReqConverter {


    static CallBackDeliveryReq convert(String callBackStr) {
        CallBackDeliveryReq result = new CallBackDeliveryReq();
        return result;
    }
}
