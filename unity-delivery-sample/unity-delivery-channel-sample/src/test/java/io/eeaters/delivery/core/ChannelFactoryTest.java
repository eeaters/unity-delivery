package io.eeaters.delivery.core;

import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.response.PreDeliveryResp;
import io.eeaters.delivery.mockito.AccountMock;
import io.eeaters.delivery.mockito.CreateDeliveryReqMock;
import org.junit.Assert;
import org.junit.Test;

public class ChannelFactoryTest {

    @Test
    public void preDelivery() {
        ChannelClientFactory channelClientFactory = new ChannelClientFactory(null);
        PreDeliveryResp preDeliveryResp = channelClientFactory.getClient(DeliveryChannelEnum.SF)
                .createPreDelivery(AccountMock.mockSF(), CreateDeliveryReqMock.sf());
        Assert.assertNotNull(preDeliveryResp);
    }
    
}
