package io.eeaters.delivery.dada.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DaDaStatusCallBackReq {
    /**
     * 达达物流订单号，默认为空
     */
    @JsonProperty("client_id")
    private String clientId;

    /**
     * 第三方订单ID，对应下单接口中的origin_id
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 订单状态
     * 待接单＝1
     * 待取货＝2
     * 骑士到店=100
     * 配送中＝3
     * 已完成＝4
     * 已取消＝5
     * 已追加待接单=8
     * 妥投异常之物品返回中=9
     * 妥投异常之物品返回完成=10
     * 售后取件单送达门店=6
     * 创建达达运单失败=1000
     */
    @JsonProperty("order_status")
    private Integer orderStatus;

    /**
     * 重复回传状态原因
     * 1-重新分配骑士
     * 2-骑士转单
     */
    @JsonProperty("repeat_reason_type")
    private Integer repeatReasonType;

    /**
     * 订单取消原因，默认值为空字符串
     */
    @JsonProperty("cancel_reason")
    private String cancelReason;

    /**
     * 订单取消原因来源
     * 1: 达达配送员取消
     * 2: 商家主动取消
     * 3: 系统或客服取消
     * 0: 默认值
     */
    @JsonProperty("cancel_from")
    private Integer cancelFrom;

    /**
     * 更新时间，时间戳除了创建达达运单失败=1000的精确毫秒，其他时间戳精确到秒
     */
    @JsonProperty("update_time")
    private Long updateTime;

    /**
     * 对clientId, orderId, updateTime的值进行字符串升序排列，再连接字符串，取md5值
     */
    @JsonProperty("signature")
    private String signature;

    /**
     * 达达配送员id，接单以后会传
     */
    @JsonProperty("dm_id")
    private Integer dmId;

    /**
     * 配送员姓名，接单以后会传
     */
    @JsonProperty("dm_name")
    private String dmName;

    /**
     * 配送员手机号，接单以后会传
     */
    @JsonProperty("dm_mobile")
    private String dmMobile;

    /**
     * 收货码
     */
    @JsonProperty("finish_code")
    private String finishCode;
}
