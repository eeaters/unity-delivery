package io.eeaters.io.eeaters.unity.delivery.sample.support;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.DeliveryRelateAccountLookUp;
import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.io.eeaters.unity.delivery.sample.config.property.DeliveryAccountPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryRelateAccountLookUpImpl implements DeliveryRelateAccountLookUp {

    @Autowired
    DeliveryAccountPropertySource accountPropertySource;

    @Override
    public Account getByDeliveryCode(DeliveryChannelEnum channelEnum, String deliveryCode) {
        return accountPropertySource.getAccount().get(channelEnum.name().toLowerCase());
    }
}
