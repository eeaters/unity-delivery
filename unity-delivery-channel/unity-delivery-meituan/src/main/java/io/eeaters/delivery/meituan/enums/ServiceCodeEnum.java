package io.eeaters.delivery.meituan.enums;

import lombok.Getter;

@Getter
public enum ServiceCodeEnum {

    FEI_SU(4002,"飞速达"),
    KUAI_SU(4011,"快速达"),
    JI_SHI(4012,"极时达"),
    JI_ZHONG(4013,"集中送")

    ;
    private Integer code;

    private String name;

    ServiceCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


}
