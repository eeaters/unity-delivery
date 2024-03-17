package io.eeaters.io.eeaters.unity.delivery.sample;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.ChannelClient;
import io.eeaters.delivery.core.ChannelClientFactory;
import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.request.CreateDeliveryReq;
import io.eeaters.delivery.core.response.PreDeliveryResp;
import io.eeaters.io.eeaters.unity.delivery.sample.config.property.DeliveryAccountPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCommandRunnable implements CommandLineRunner {

    @Autowired
    ChannelClientFactory clientFactory;

    @Autowired
    DeliveryAccountPropertySource propertySource;

    @Override
    public void run(String... args) throws Exception {
        ChannelClient channelClient = clientFactory.getClient(DeliveryChannelEnum.SF);

        Account account = propertySource.getAccount().get(DeliveryChannelEnum.SF.name().toLowerCase());

        CreateDeliveryReq createDeliveryDTO = new CreateDeliveryReq();
        createDeliveryDTO.setStoreCode("999999");
        createDeliveryDTO.setWeightGram(10);
        createDeliveryDTO.setOrderSource("配送测试");

        CreateDeliveryReq.ContractInformation information = new CreateDeliveryReq.ContractInformation();
        information.setLatitude(40.030613);
        information.setLongitude(116.354787);
        information.setAddress("海淀区清河龙岗路51号清润家园小区 永辉");
        information.setContractUser("eeaters");
        information.setContractPhone("13333333333");
        createDeliveryDTO.setUserInformation(information);

        PreDeliveryResp preDelivery = channelClient.createPreDelivery(account, createDeliveryDTO);
        System.out.println("preDelivery = " + preDelivery);
    }
}
