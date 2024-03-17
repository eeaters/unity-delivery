package io.eeaters.io.eeaters.unity.delivery.sample.config;

import io.eeaters.delivery.core.CallBackListener;
import io.eeaters.delivery.core.ChannelClientFactory;
import io.eeaters.delivery.core.DeliveryRelateAccountLookUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration(proxyBeanMethods = false)
public class UnityDeliveryConfig {

    @Autowired
    private List<CallBackListener> callBackListenerList;

    @Autowired
    private DeliveryRelateAccountLookUp deliveryRelateAccountLookUp;


    @Bean
    public ChannelClientFactory channelClientFactory() {
        ChannelClientFactory channelClientFactory = new ChannelClientFactory(deliveryRelateAccountLookUp);
        channelClientFactory.setCallBackListener(callBackListenerList);
        return channelClientFactory;
    }

}
