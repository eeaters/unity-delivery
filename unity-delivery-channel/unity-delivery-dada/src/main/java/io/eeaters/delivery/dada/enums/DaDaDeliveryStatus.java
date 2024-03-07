package io.eeaters.delivery.dada.enums;

import io.eeaters.delivery.core.enums.DeliveryStatusEnum;
import lombok.Getter;

import java.util.Objects;

/**
 * 待接单＝1,待取货＝2,骑士到店=100,配送中＝3,已完成＝4,已取消＝5, 已追加待接单=8,妥投异常之物品返回中=9, 妥投异常之物品返回完成=10, 售后取件单送达门店=6, 创建达达运单失败=1000
 *
 *
 * <img src="https://crms.imdada.cn/goose/9a744900/images/order-flow-01.e66cba.png">
 */
@Getter
public enum DaDaDeliveryStatus {

    CHANNEL_RECEIVE(1, DeliveryStatusEnum.CHANNEL_RECEIVE, "待接单"),

    RIDER_RECEIVE(2, DeliveryStatusEnum.RIDER_RECEIVE, "待取货"),

    ARRIVE_SHOP(100, DeliveryStatusEnum.ARRIVE_SHOP, "骑手已到店"),

    DELIVERING(3, DeliveryStatusEnum.DELIVERING, "配送中"),

    COMPLETE(4, DeliveryStatusEnum.COMPLETE, "运单已完成"),

    CANCEL(5, DeliveryStatusEnum.CANCEL, "运单已取消"),

    EXCEPTION(9, DeliveryStatusEnum.EXCEPTION, "运单异常"),

    COMPLETE_RETURN(10, DeliveryStatusEnum.COMPLETE_RETURN, "运单已退回商家"),

    CREATE_ERROR(1000, DeliveryStatusEnum.CANCEL, "创建达达订单失败"),
    ;
    private Integer dadaCode;

    private DeliveryStatusEnum statusEnum;

    private String desc;

    DaDaDeliveryStatus(Integer dadaCode, DeliveryStatusEnum statusEnum, String desc) {
        this.dadaCode = dadaCode;
        this.statusEnum = statusEnum;
        this.desc = desc;
    }

    public static DaDaDeliveryStatus of(Integer dadaCode) {
        for (DaDaDeliveryStatus value : values()) {
            if (Objects.equals(dadaCode, value.dadaCode)) {
                return value;
            }
        }
        return null;
    }


}
