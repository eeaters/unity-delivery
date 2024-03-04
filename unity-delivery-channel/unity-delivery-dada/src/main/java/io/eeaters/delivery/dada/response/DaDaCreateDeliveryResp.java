package io.eeaters.delivery.dada.response;

import lombok.Data;

@Data
public class DaDaCreateDeliveryResp {

    private Double distance;

    private Double fee;

    private Double deliverFee;

    private Double insuranceFee;

    private Double tips;
}
