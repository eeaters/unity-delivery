package io.eeaters.delivery.core;

import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.exception.UnsupportedException;
import io.eeaters.delivery.core.util.ServiceLoaderUtils;

import java.util.List;

public class ChannelClientFactory {

    private final List<ChannelClient> clientList = ServiceLoaderUtils.loadSPI(ChannelClient.class);

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
        throw new UnsupportedException("不支持的渠道");
    }

    /**
     *
     * @param callBackStr 回调信息¬
     * @param sign 放在url中的签名，如果在callBackStr中则传 null
     * @param channelEnum 渠道
     * @return 直接吐给三方的响应信息
     */
    public Object callBackHandler(String callBackStr, String sign, DeliveryChannelEnum channelEnum) {
        CallBackContext callBackContext = new CallBackContext(callBackStr,sign, accountLookUp);

        getClient(channelEnum).callBackHandler(callBackContext);
        if (callBackContext.getSignVerify()) {
            //这里增加一个消息通知
        }

        return callBackContext.returnResult();
    }

}
