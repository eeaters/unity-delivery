package io.eeaters.delivery.dada.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DaDaQueryDeliveryInfoReq {

    @JsonProperty("order_id")
    private String orderId;
}
