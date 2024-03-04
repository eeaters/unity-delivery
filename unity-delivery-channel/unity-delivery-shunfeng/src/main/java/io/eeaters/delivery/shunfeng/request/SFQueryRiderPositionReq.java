package io.eeaters.delivery.shunfeng.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SFQueryRiderPositionReq {

    /**
     * API开发者ID
     */
    @JsonProperty("dev_id")
    private Integer devId;

    /**
     * 订单ID
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 查询订单ID类型：1、顺丰订单号 2、商家订单号
     */
    @JsonProperty("order_type")
    private Integer orderType;

    /**
     * 店铺ID，当 order_type=2 时必传；shop_id 与 shop_type
     */
    @JsonProperty("shop_id")
    private String shopId;

    /**
     * 店铺ID类型：1、顺丰店铺ID 2、接入方店铺ID
     */
    @JsonProperty("shop_type")
    private Integer shopType;

    /**
     * 推送时间（秒级时间戳）
     */
    @JsonProperty("push_time")
    private Integer pushTime;

}
