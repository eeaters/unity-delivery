package io.eeaters.delivery.core.request;

import lombok.Data;

@Data
public class QueryRiderPositionReq {

    private String storeCode;

    private String channelOrderId;

    private String deliveryCode;
}
