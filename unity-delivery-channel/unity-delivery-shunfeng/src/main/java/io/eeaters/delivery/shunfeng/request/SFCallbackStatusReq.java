package io.eeaters.delivery.shunfeng.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SFCallbackStatusReq {

    @JsonProperty("shop_id")
    private String shopId;
    @JsonProperty("sf_order_id")
    private String sfOrderId;
    @JsonProperty("shop_order_id")
    private String shopOrderId;
    @JsonProperty("url_index")
    private String urlIndex;
    @JsonProperty("order_status")
    private Integer orderStatus;
    @JsonProperty("status_desc")
    private String statusDesc;
    @JsonProperty("push_time")
    private Integer pushTime;
    @JsonProperty("sf_ucode")
    private String sfUcode;

}
