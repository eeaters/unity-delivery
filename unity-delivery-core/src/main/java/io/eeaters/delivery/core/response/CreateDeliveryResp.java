package io.eeaters.delivery.core.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateDeliveryResp{

    private String channelOrderId;

    private Integer totalPrice;

    private LocalDateTime pushTime;

    public CreateDeliveryResp(){
    }

}
