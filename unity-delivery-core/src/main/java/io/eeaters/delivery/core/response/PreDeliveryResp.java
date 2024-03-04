package io.eeaters.delivery.core.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class PreDeliveryResp{

    //预计配送的金额
    private Integer totalPrice;

    //预计送达时间
    private LocalDateTime expectTime;

}
