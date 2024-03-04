package io.eeaters.delivery.dada.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DaDaCreateDeliveryReq {
    /**
     *  门店编号，门店创建后可在门店列表和单页查看
     */
    @JsonProperty("shop_no")
    private String shopNo;
    /**
     * 第三方订单ID
     */
    @JsonProperty("origin_id")
    private String originId;
    /**
     * 订单所在城市的code
     */
    @JsonProperty("city_code")
    private String cityCode;
    /**
     * 订单金额（单位：元）
     */
    @JsonProperty("cargo_price")
    private Double cargoPrice;

    /**
     * 订单金额（单位：Kg）
     */
    @JsonProperty("cargo_weight")
    private Double cargoWeight;

    /**
     * 是否需要垫付 1:是 0:否 (垫付订单金额，非运费)
     */
    @JsonProperty("is_prepay")
    private Integer isPrepay;
    /**
     * 收货人姓名
     */
    @JsonProperty("receiver_name")
    private String receiverName;
    /**
     * 收货人地址
     */
    @JsonProperty("receiver_address")
    private String receiverAddress;
    /**
     * 收货人地址维度（高德坐标系）
     */
    @JsonProperty("receiver_lat")
    private Double receiverLat;
    /**
     * 收货人地址经度（高德坐标系）
     */
    @JsonProperty("receiver_lng")
    private Double receiverLng;
    /**
     * 回调URL
     */
    @JsonProperty("callback")
    private String callback;
    /**
     * 收货人手机号（手机号和座机号必填一项）
     */
    @JsonProperty("receiver_phone")
    private String receiverPhone;
    /**
     * 收货人座机号（手机号和座机号必填一项）
     */
    @JsonProperty("receiver_tel")
    private String receiverTel;
    /**
     * 订单备注
     */
    @JsonProperty("info")
    private String info;

    /**
     * 预约发单时间
     */
    @JsonProperty("delay_publish_time")
    private Integer delayPublishTime;

    /**
     * 订单来源标示（该字段可以显示在达达app订单详情页面，只支持字母，最大长度为10）
     */
    @JsonProperty("origin_mark")
    private String originMark;

    /**
     * 订单来源编号（该字段可以显示在达达app订单详情页面，支持字母和数字，最大长度为30）
     */
    @JsonProperty("origin_mark_no")
    private String originMarkNo;
}
