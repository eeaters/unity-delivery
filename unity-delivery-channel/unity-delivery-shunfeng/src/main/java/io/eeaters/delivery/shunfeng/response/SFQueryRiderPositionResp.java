package io.eeaters.delivery.shunfeng.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SFQueryRiderPositionResp {
    /**
     * 顺丰订单号，新版本V1.9+升级为JS开头的15位字符串类型，老版本为int类型
     */
    @JsonProperty("sf_order_id")
    private String sfOrderId;

    /**
     * 商家订单号
     */
    @JsonProperty("shop_order_id")
    private String shopOrderId;

    /**
     * 配送员姓名
     */
    @JsonProperty("rider_name")
    private String riderName;

    /**
     * 配送员联系方式
     */
    @JsonProperty("rider_phone")
    private String riderPhone;

    /**
     * 配送员经度
     */
    @JsonProperty("rider_lng")
    private String riderLng;

    /**
     * 配送员纬度
     */
    @JsonProperty("rider_lat")
    private String riderLat;

    /**
     * 坐标上传时间（秒级时间戳）
     */
    @JsonProperty("upload_time")
    private String uploadTime;
}
