package io.eeaters.delivery.shunfeng.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SFQueryDeliveryResp {

    /**
     * 顺丰订单号，新版本V1.9+升级为JS开头的15位字符串类型，老版本为int类型
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 顺丰店铺ID
     */
    @JsonProperty("shop_id")
    private Long shopId;

    /**
     * 商家订单ID
     */
    @JsonProperty("out_order_id")
    private String outOrderId;

    /**
     * 当前状态
     */
    @JsonProperty("order_status")
    private Integer orderStatus;

    /**
     * 当前状态描述
     */
    @JsonProperty("status_desc")
    private String statusDesc;

    /**
     * 骑士名称
     */
    @JsonProperty("rider_name")
    private String riderName;

    /**
     * 骑手电话
     */
    @JsonProperty("rider_phone")
    private String riderPhone;

    /**
     * 订单推送生成的时间（秒级时间戳）
     */
    @JsonProperty("push_time")
    private Integer pushTime;

    /**
     * 配送费总额
     */
    @JsonProperty("total_price")
    private Integer totalPrice;

    /**
     * 配送距离（单位：米）
     */
    @JsonProperty("delivery_distance_meter")
    private Integer deliveryDistanceMeter;

    /**
     * 商品重量（单位：克）
     */
    @JsonProperty("weight_gram")
    private Integer weightGram;

    /**
     * 起送时间（秒级时间戳）
     */
    @JsonProperty("start_time")
    private Long startTime;

    /**
     * 预计送达时间（秒级时间戳）
     */
    @JsonProperty("expect_time")
    private Long expectTime;

    /**
     * 支付费用
     */
    @JsonProperty("total_pay_money")
    private Integer totalPayMoney;

    /**
     * 实际支付金额
     */
    @JsonProperty("real_pay_money")
    private Integer realPayMoney;

    /**
     * 优惠券总金额
     */
    @JsonProperty("coupons_total_fee")
    private Integer couponsTotalFee;

    /**
     * 结算方式
     */
    @JsonProperty("settlement_type")
    private Integer settlementType;

    /**
     * 取件码
     */
    @JsonProperty("pickup_code")
    private Integer pickupCode;

    /**
     * 签收码
     */
    @JsonProperty("complete_code")
    private Integer completeCode;

    /**
     * 爆单费，单位分
     */
    @JsonProperty("overflow_fee")
    private Integer overflowFee;

    /**
     * 省心送费，单位分。在顺丰同城后台配置，配置后有此字段和费用
     */
    @JsonProperty("free_send_service_fee")
    private Integer freeSendServiceFee;
}
