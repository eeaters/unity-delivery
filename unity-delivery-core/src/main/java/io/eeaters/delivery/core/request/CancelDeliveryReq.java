package io.eeaters.delivery.core.request;

import io.eeaters.delivery.core.enums.CancelReasonEnum;
import lombok.Data;

@Data
public class CancelDeliveryReq {

    private String storeCode;

    private String channelOrderId;

    private String deliveryCode;

    private CancelReasonEnum cancelReasonEnum;

    private String cancelReasonDesc;
}
