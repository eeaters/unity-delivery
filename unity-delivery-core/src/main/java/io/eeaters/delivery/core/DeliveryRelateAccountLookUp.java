package io.eeaters.delivery.core;

import io.eeaters.delivery.core.enums.DeliveryChannelEnum;

/**
 * 当三方回调时， 如何根据
 */
public interface DeliveryRelateAccountLookUp {

    Account getByDeliveryCode(DeliveryChannelEnum channelEnum, String deliveryCode);

}
