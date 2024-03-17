package io.eeaters.delivery.shunfeng.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SFCallbackStatusReq {

    //============== 通用响应 start =================
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

    //============== 状态回调响应 start =================
    @JsonProperty("operator_name")
    private String operatorName;
    @JsonProperty("operator_phone")
    private String operatorPhone;
    @JsonProperty("rider_lng")
    private String riderLng;
    @JsonProperty("rider_lat")
    private String riderLat;

    //============== 配送完成响应 start =================

    @JsonProperty("pickup_pic")
    private List<String> pickupPic;
    @JsonProperty("receipt_type")
    private Integer receiptType;
    //============== 取消 start =================

    @JsonProperty("cancel_reason")
    private String cancelReason;
    @JsonProperty("cancel_code")
    private String cancelCode;

    //============== 异常上报 start =================
    @JsonProperty("ex_id")
    private Integer exId;
    @JsonProperty("ex_content")
    private String exContent;
    @JsonProperty("expect_time")
    private String expectTime;

    //============== 骑手撤单 已包含 =================


}
