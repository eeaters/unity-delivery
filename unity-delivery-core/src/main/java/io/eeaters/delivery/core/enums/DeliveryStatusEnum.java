package io.eeaters.delivery.core.enums;

import lombok.Getter;

/**
 *
 */
@Getter
public enum DeliveryStatusEnum {

    //initial status
    WAIT_HANDLE(0, "待处理"),

    WAIT_RECEIVE(2, "待接单"),

    // on delivering status
    CHANNEL_RECEIVE(10, "渠道已接单"),

    RIDER_RECEIVE(12, "骑手已接单"),

    ARRIVE_SHOP(14,  "骑手已到店"),

    RIDER_READY(16,  "骑手已取餐"),

    DELIVERING(18,  "配送中"),

    // error status
    PUSH_ERROR(20, "推送运单失败"),

    CHARGEBACKS(22, "骑手撤销运单"),

    EXCEPTION(24, "运单异常"),

    // terminal status
    COMPLETE(30,  "运单已完成"),

    COMPLETE_RETURN( 32,  "运单已退回商家"),

    CANCEL(34, "运单已取消"),


    ;
    private Integer code;

    private String desc;

    DeliveryStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
