package io.eeaters.delivery.shunfeng.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SFCreateDeliveryResp {

    @JsonProperty("sf_order_id")
    private String sfOrderId;
    @JsonProperty("sf_bill_id")
    private String sfBillId;
    @JsonProperty("shop_order_id")
    private String shopOrderId;
    @JsonProperty("push_time")
    private Integer pushTime;
    @JsonProperty("total_price")
    private Integer totalPrice;
    @JsonProperty("pickup_code")
    private Integer pickupCode;
    @JsonProperty("complete_code")
    private Integer completeCode;
    @JsonProperty("gratuity_fee")
    private Integer gratuityFee;
    @JsonProperty("insure_fee")
    private Integer insureFee;
}
