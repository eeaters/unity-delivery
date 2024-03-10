package io.eeaters.delivery.core;

import io.eeaters.delivery.core.request.CallBackDeliveryReq;
import lombok.Getter;

@Getter
public class CallBackContext {

    private final String callbackStr;

    private final String sign;

    private final DeliveryRelateAccountLookUp accountLookUp;

    private CallBackDeliveryReq deliveryReq;

    private Boolean signVerify = Boolean.TRUE;

    private CallBackResultGenerate resultGenerate;

    public CallBackContext(String callbackStr, String sign, DeliveryRelateAccountLookUp accountLookUp) {
        this.callbackStr = callbackStr;
        this.accountLookUp = accountLookUp;
        this.sign = sign;
    }

    public void init(Boolean signVerify, CallBackResultGenerate generate, CallBackDeliveryReq deliveryReq) {
        this.signVerify = signVerify;
        this.resultGenerate = generate;
        this.deliveryReq = deliveryReq;
    }


    public Object returnResult() {
        return resultGenerate.generate(signVerify);
    }
}
