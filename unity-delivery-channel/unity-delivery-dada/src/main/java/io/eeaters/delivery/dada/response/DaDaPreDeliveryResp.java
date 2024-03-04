package io.eeaters.delivery.dada.response;

import lombok.Data;

/**
 * {
 *               "distance": 1004.0,
 *               "fee": 123.22,
 *               "deliverFee": 123.22,
 *               "deliveryNo": "Dada18cf5bdd0f764c9dbfdbb5c0a9b2ea7b",
 *               "insuranceFee": 0.0,
 *               "tips": 1.0,
 *               "expiredTime": 1653709642
 *             }
 */
@Data
public class DaDaPreDeliveryResp {

    /**
     * 	配送距离(单位：米)  *
     */
    private Double distance;

    /**
     * 实际运费(单位：元)，运费减去优惠券费用 *
     */
    private Double fee;

    /**
     * 运费(单位：元) *
     */
    private Double deliveryFee;

    /**
     * 	平台订单号 *
     */
    private String deliveryNo;

    /**
     * 保价费(单位：元)
     */
    private Double insuranceFee;

    /**
     * 小费（单位：元，精确小数点后一位，小费金额不能高于订单金额。）
     */
    private Double tips;

    /**
     * 期望送达时间
     */
    private Long expiredTime;

}
