package io.eeaters.delivery.shunfeng.enums;

import io.eeaters.delivery.core.enums.DeliveryStatusEnum;
import lombok.Getter;

import java.util.Objects;

/**
 * <a href="https://commit-openic.sf-express.com/#/quickstart">顺丰同城状态说明</a>
 * <br/>
 * <img src="https://crm-1258916733.cos.ap-shanghai.myqcloud.com/97/de/ec1315215c9d05b2b0f52d81f07ca2b1/open-20231031.png"></img>
 */
@Getter
public enum SFDeliveryStatus {

    CREATE(1, DeliveryStatusEnum.CHANNEL_RECEIVE,"订单创建"),

    CANCEL(2, DeliveryStatusEnum.CANCEL, "订单取消"),

    RIDER_RECEIVED(10, DeliveryStatusEnum.RIDER_RECEIVE, "配送员接单"),

    ARRIVE_STORE(12, DeliveryStatusEnum.ARRIVE_SHOP, "配送员到店"),

    DELIVERING(15, DeliveryStatusEnum.DELIVERING, "配送员配送中"),

    COMPLETED(17, 1, DeliveryStatusEnum.COMPLETE, "配送员完成订单"),
    COMPLETED_RETURN(17, 2, DeliveryStatusEnum.COMPLETE_RETURN, "配送员完成订单-退回商家"),

    ERROR(91, DeliveryStatusEnum.EXCEPTION, "订单异常"),
    ;

    private Integer sfCode;

    private DeliveryStatusEnum statusEnum;
    private String desc;
    private Integer receiptType;

    SFDeliveryStatus(Integer sfCode, DeliveryStatusEnum statusEnum, String desc) {
        this(sfCode, 1, statusEnum, desc);
    }

    SFDeliveryStatus(Integer sfCode, Integer receiptType, DeliveryStatusEnum statusEnum, String desc) {
        this.sfCode = sfCode;
        this.receiptType = receiptType;
        this.statusEnum = statusEnum;
        this.desc = desc;
    }

    public static SFDeliveryStatus valueOf(Integer sfCode) {
        return valueOf(sfCode, 1);
    }

    public static SFDeliveryStatus valueOf(Integer sfCode, Integer receiptType) {
        for (SFDeliveryStatus value : values()) {
            if (Objects.equals(value.sfCode, sfCode) && Objects.equals(receiptType, value.receiptType)) {
                return value;
            }
        }
        return null;
    }
}
