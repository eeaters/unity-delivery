package io.eeaters.io.eeaters.unity.delivery.sample.support;

import io.eeaters.delivery.core.CallBackListener;
import io.eeaters.delivery.core.request.CallBackDeliveryReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallBackLogListener implements CallBackListener {
    @Override
    public void eventListener(String callBackStr, CallBackDeliveryReq callBackDeliveryReq) {
        log.info("回调源信息:{} , 回调统一信息:{}", callBackStr, callBackDeliveryReq);
    }
}
