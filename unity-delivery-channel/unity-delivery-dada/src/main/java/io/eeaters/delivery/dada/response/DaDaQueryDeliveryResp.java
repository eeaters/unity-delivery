package io.eeaters.delivery.dada.response;

import lombok.Data;

@Data
public class DaDaQueryDeliveryResp {
    private String orderId;
    private Integer statusCode;
    private String statusMsg;
    private String transporterName;
    private String transporterPhone;
    private String transporterLng;
    private String transporterLat;
    private Double deliveryFee;
    private Double tips;
    private Double couponFee;
    private Double insuranceFee;
    private Double actualFee;
    private Double distance;
    private String createTime;
    private String acceptTime;
    private String fetchTime;
    private String finishTime;
    private String cancelTime;
    private String orderFinishCode;
    private Double deductFee;
}
