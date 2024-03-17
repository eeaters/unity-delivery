package io.eeaters.delivery.core;


import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.request.CallBackDeliveryReq;

/**
 * 回调处理类
 */
public interface CallBackHandler {

    /**
     *
     * @param callBackStr 回调信息
     * @param sign 回调签名
     * @param accountLookUp 根据订单查找账号的support工具
     * @return 统一回调信息
     */
    CallBackDeliveryReq handlerCallBack(String callBackStr, String sign, DeliveryRelateAccountLookUp accountLookUp);

    /**
     * 本次回调生成的响应信息
     * @param verify 签名是否通过
     * @return 响应信息
     */
    Object generate(Boolean verify);


    DeliveryChannelEnum supportChannel();


}
