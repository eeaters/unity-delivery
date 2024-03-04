package io.eeaters.delivery.dada.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 取消ID	取消原因
 * 1	没有配送员接单
 * 2	配送员没来取货
 * 3	配送员态度太差
 * 4	顾客取消订单
 * 5	订单填写错误
 * 34	配送员让我取消此单
 * 35	配送员不愿上门取货
 * 36	我不需要配送了
 * 37	配送员以各种理由表示无法完成订单
 * 10000	其他
 */
@Data
public class DaDaCancelDeliveryReq {
    /**
     * 订单号
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 取消原因ID
     */
    @JsonProperty("cancel_reason_id")
    private Integer cancelReasonId;

    /**
     * 取消原因
     */
    @JsonProperty("cancel_reason")
    private String cancelReason;
}
