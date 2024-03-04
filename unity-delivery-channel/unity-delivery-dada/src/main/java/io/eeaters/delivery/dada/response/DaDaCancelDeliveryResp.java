package io.eeaters.delivery.dada.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DaDaCancelDeliveryResp {

    //扣除的违约金
    @JsonProperty("deduct_fee")
    private Double deductFee;
}
