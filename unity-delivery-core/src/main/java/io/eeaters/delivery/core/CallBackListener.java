package io.eeaters.delivery.core;

import io.eeaters.delivery.core.request.CallBackDeliveryReq;

/**
 * 三方回调的listener
 */
public interface CallBackListener {

    void eventListener(CallBackDeliveryReq callBackDeliveryReq);

}
