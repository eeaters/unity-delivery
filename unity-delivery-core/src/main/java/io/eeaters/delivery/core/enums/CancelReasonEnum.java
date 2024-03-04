package io.eeaters.delivery.core.enums;

import lombok.Getter;

@Getter
public enum CancelReasonEnum {

    CUSTOMER_CANCEL("顾客主动取消"),

    MERCHANT_CANCEL("商家主动取消"),

    OTHER("其他"),
    ;
    private String desc;

    CancelReasonEnum(String desc) {
        this.desc = desc;
    }
}
