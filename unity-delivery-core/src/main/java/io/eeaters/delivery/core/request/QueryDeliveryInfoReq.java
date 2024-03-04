package io.eeaters.delivery.core.request;

import io.eeaters.delivery.core.response.CreateDeliveryResp;
import lombok.Data;

/**
 * {@link CreateDeliveryResp#channelOrderId} 可能部分平台不支持
 * 但
 * deliveryCode 一定所有平台都支持
 */
@Data
public class QueryDeliveryInfoReq {

    private String storeCode;

    private String deliveryCode;

}
