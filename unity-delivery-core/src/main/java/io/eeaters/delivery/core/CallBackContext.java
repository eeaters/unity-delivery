package io.eeaters.delivery.core;

import io.eeaters.delivery.core.request.CallBackDeliveryReq;
import lombok.Getter;

@Getter
public class CallBackContext {

    /**
     * 三方回调原始报文
     */
    private final String callbackStr;

    /**
     * 三方回调的签名
     */
    private final String sign;

    /**
     * 根据deliveryCode查账号信息
     */
    private final DeliveryRelateAccountLookUp accountLookUp;

    /**
     * 统一认证后的回调信息
     */
    private CallBackDeliveryReq deliveryReq;

    /**
     * 校验是否通过
     */
    private Boolean signVerify = Boolean.FALSE;


    public CallBackContext(String callbackStr, String sign, DeliveryRelateAccountLookUp accountLookUp) {
        this.callbackStr = callbackStr;
        this.accountLookUp = accountLookUp;
        this.sign = sign;
    }

    public void init(Boolean signVerify, CallBackDeliveryReq deliveryReq) {
        this.signVerify = signVerify;
        this.deliveryReq = deliveryReq;
    }

}
