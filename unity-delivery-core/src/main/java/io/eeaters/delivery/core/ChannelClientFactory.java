package io.eeaters.delivery.core;

import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.exception.UnsupportedException;
import io.eeaters.delivery.core.util.ServiceLoaderUtils;

import java.util.List;

public class ChannelClientFactory {

    private List<ChannelClient> clientList = ServiceLoaderUtils.loadSPI(ChannelClient.class);

    public DeliveryRelateAccountLookUp lookUp;

    public ChannelClientFactory(DeliveryRelateAccountLookUp lookUp) {
        this.lookUp = lookUp;
    }

    public ChannelClient getClient(DeliveryChannelEnum channelEnum) {
        for (ChannelClient channelClient : clientList) {
            if (channelEnum == channelClient.supportChannel()) {
                return channelClient;
            }
        }
        throw new UnsupportedException("不支持的渠道");
    }

    public void getClient(String deliveryCode, DeliveryChannelEnum channelEnum) {
        return ;
    }
}
