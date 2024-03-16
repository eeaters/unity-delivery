package io.eeaters.delivery.core;

import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.exception.UnsupportedException;
import io.eeaters.delivery.core.request.CallBackDeliveryReq;
import io.eeaters.delivery.core.util.ServiceLoaderUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChannelClientFactory {

    private final List<ChannelClient> clientList = ServiceLoaderUtils.loadSPI(ChannelClient.class);

    private final List<CallBackHandler> generateList = ServiceLoaderUtils.loadSPI(CallBackHandler.class);

    private List<CallBackListener> callBackListeners = new ArrayList<>();

    public DeliveryRelateAccountLookUp accountLookUp;

    public ChannelClientFactory(DeliveryRelateAccountLookUp accountLookUp) {
        this.accountLookUp = accountLookUp;
    }

    public ChannelClient getClient(DeliveryChannelEnum channelEnum) {
        for (ChannelClient channelClient : clientList) {
            if (channelEnum == channelClient.supportChannel()) {
                return channelClient;
            }
        }
        throw new UnsupportedException("不支持的渠道: " + channelEnum.name());
    }

    /**
     *
     * @param callBackStr 回调信息¬
     * @param sign 放在url中的签名，如果在callBackStr中则传 null
     * @param channelEnum 渠道
     * @return 直接吐给三方的响应信息
     */
    public Object callBackHandler(String callBackStr, String sign, DeliveryChannelEnum channelEnum) {
        CallBackHandler callBackHandler = getCallBackHandler(channelEnum);

        CallBackDeliveryReq deliveryReq = callBackHandler.handlerCallBack(callBackStr, sign, accountLookUp);
        if (deliveryReq.getSignVerify()) {
            notifyListener(deliveryReq);
        }
        return callBackHandler.generate(deliveryReq.getSignVerify());

    }

    public void setCallBackListener(CallBackListener... callBackListeners) {
        this.callBackListeners.addAll(Arrays.asList(callBackListeners));
    }

    void notifyListener(CallBackDeliveryReq deliveryReq) {
        for (CallBackListener callBackListener : callBackListeners) {
            callBackListener.eventListener(deliveryReq);
        }
    }

    CallBackHandler getCallBackHandler(DeliveryChannelEnum channelEnum) {
        for (CallBackHandler callBackHandler : generateList) {
            if (callBackHandler.supportChannel() == channelEnum) {
                return callBackHandler;
            }
        }
        throw new UnsupportedException("不支持的渠道:" + channelEnum.name());
    }

}
