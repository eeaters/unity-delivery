package io.eeaters.delivery.meituan.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreatePreMtDeliveryReq {

    /**
     * 即配送活动标识，由外部系统生成，不同order_id应对应不同的delivery_id，若因美团系统故障导致发单接口失败，可利用相同的delivery_id重新发单，系统视为同一次配送活动，若更换delivery_id，则系统视为两次独立配送活动。
     */
    @JsonProperty("delivery_id")
    private Long deliveryId;

    /**
     * 订单id，即该订单在合作方系统中的id，最长不超过32个字符
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 取货门店id，即合作方向美团提供的门店id 注：测试门店的shop_id固定为 test_0001 ，仅用于对接时联调测试。
     */
    @JsonProperty("shop_id")
    private String shopId;

    /**
     * 配送服务代码，详情见合同 飞速达:4002 快速达:4011 及时达:4012 集中送:4013
     */
    @JsonProperty("delivery_service_code")
    private Integer deliveryServiceCode;

    /**
     * 收件人名称，最长不超过256个字符
     */
    @JsonProperty("receiver_name")
    private String receiverName;
    /**
     * 收件人地址，最长不超过512个字符
     */
    @JsonProperty("receiver_address")
    private String receiverAddress;
    /**
     * 收件人电话，最长不超过64个字符
     */
    @JsonProperty("receiver_phone")
    private String receiverPhone;
    /**
     * 收件人经度
     */
    @JsonProperty("receiver_lng")
    private Integer receiverLng;
    /**
     * 收件人纬度
     */
    @JsonProperty("receiver_lat")
    private Integer receiverLat;
    /**
     * 坐标类型，0：火星坐标（高德，腾讯地图均采用火星坐标） 1：百度坐标 （默认值为0）
     */
    @JsonProperty("coordinate_type")
    private Integer coordinateType;
    /**
     * 货物价格，单位为元，精确到小数点后两位，范围为0-5000 --是
     */
    @JsonProperty("goods_value")
    private Double goodsValue;
    /**
     * 货物高度，单位为cm，精确到小数点后两位，范围为0-45 --否
     */
    @JsonProperty("goods_height")
    private Double goodsHeight;
    /**
     * 货物宽度，单位为cm，精确到小数点后两位，范围为0-50--否
     */
    @JsonProperty("goods_width")
    private Double goodsWidth;
    /**
     * 货物长度，单位为cm，精确到小数点后两位，范围为0-65--否
     */
    @JsonProperty("goods_length")
    private Double goodsLength;
    /**
     * 货物重量，单位为kg，精确到小数点后两位，范围为0-50--是
     */
    @JsonProperty("goods_weight")
    private Double goodsWeight;
    /**
     * 货物详情 --否
     */
    @JsonProperty("goods_detail")
    private String goodsDetail;
    /**
     * 货物取货信息，用于骑手到店取货，最长不超过100个字符 --否
     */

    @JsonProperty("goods_pickup_info")
    private String goodsPickupInfo;
    /**
     * 货物交付信息，最长不超过100个字符 --否
     */

    @JsonProperty("goods_delivery_info")
    private String goodsDeliveryInfo;
    /**
     * 期望送达时间，时区为GMT+8，当前距离Epoch（1970年1月1日) 以秒计算的时间，即unix-timestamp
     *
     * 注意事项
     * 1.发单配送服务为跑腿-帮送，且订单类型为预约单时该字段为必填。
     * 2.发单配送服务为跑腿-帮送，且订单类型为即时单时则 不允许设置此字段。
     * 3.其他情况该字段为选填，传值后也不会按此时间取货。
     */
    @JsonProperty("expected_pickup_time")
    private Long expectedPickupTime;
    /**
     * 期望取货时间，时区为GMT+8，当前距离Epoch（1970年1月1日) 以秒计算的时间，即unix-timestamp。--否
     */
    @JsonProperty("expected_delivery_time")
    private Long expectedDeliveryTime;
    /**
     * 订单类型，默认为00: 即时单(尽快送达，限当日订单)1: 预约单 --否
     */
    @JsonProperty("order_type")
    private Integer orderType;
    /**
     * 门店订单流水号，建议提供，方便骑手门店取货 --否
     */
    @JsonProperty("poi_seq")
    private String poiSeq;
    /**
     * 备注，最长不超过200个字符。 --否
     */
    private String note;
    /**
     * 骑手应付金额，单位为元，精确到分【预留字段】 --否
     */
    @JsonProperty("cash_on_delivery")
    private Double cashOnDelivery;
    /**
     * 骑手应收金额，单位为元，精确到分【预留字段】 -- 否
     */
    @JsonProperty("cash_on_pickup")
    private Double cashOnPickup;
    /**
     * 发票抬头，最长不超过256个字符【预留字段】
     */
    @JsonProperty("invoice_title")
    private String invoiceTitle;

    /**
     * 订单来源
     */
    @JsonProperty("outer_order_source_desc")
    private  String outerOrderSourceDesc;

    /**
     *  美团订单号
     */
    @JsonProperty("outer_order_source_no")
    private String outerOrderSourceNo;

    /**
     * 支付方式，0、账期支付，1、余额支付
     */
    @JsonProperty("pay_type_code")
    private Integer payTypeCode;
}
