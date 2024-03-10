package io.eeaters.delivery.core;

import io.eeaters.delivery.core.enums.DeliveryChannelEnum;

/**
 * 当三方回调时， 根据三方运单号查找渠道账号， 验签需要根据账号来验
 */
public interface DeliveryRelateAccountLookUp {

    Account getByDeliveryCode(DeliveryChannelEnum channelEnum, String deliveryCode);

}
