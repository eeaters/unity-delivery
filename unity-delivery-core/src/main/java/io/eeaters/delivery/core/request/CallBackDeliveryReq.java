package io.eeaters.delivery.core.request;

import io.eeaters.delivery.core.CallBackHandler;
import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.enums.DeliveryStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CallBackDeliveryReq {

    private String storeCode;

    private String channelOrderId;

    private String deliveryCode;

    private String riderName;

    private String riderPhone;

    private DeliveryStatusEnum statusEnum;

    private Integer actuallyFee;

    private BigDecimal distance;

    private DeliveryChannelEnum channelEnum;

    private Boolean signVerify;

}
