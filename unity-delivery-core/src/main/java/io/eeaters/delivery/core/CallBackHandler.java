package io.eeaters.delivery.core;


import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.request.CallBackDeliveryReq;

public interface CallBackHandler {

    /**
     * 回调处理
     *
     * @param callBackContext 回调上下文
     * @return 系统识别的回调信息
     */
    CallBackDeliveryReq handlerCallBack(String callBackStr, String sign, DeliveryRelateAccountLookUp accountLookUp);

    Object generate(Boolean verify);


    DeliveryChannelEnum supportChannel();


}
