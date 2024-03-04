package io.eeaters.delivery.shunfeng.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SFPreDeliveryResp {
    @JsonProperty("total_price")
    private Integer totalPrice;

    @JsonProperty("expect_time")
    private Integer expectTime;
}
