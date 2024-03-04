package io.eeaters.delivery.core.response;

import lombok.Data;

@Data
public class QueryDeliveryInfoResp  {

    /**
     * 最新配送状态
     */
    private Integer deliveryStatus;
    /**
     * 骑手名字
     */
    private String riderName;
    /**
     * 骑手手机号
     */
    private String riderPhone;

    /**
     * 订单描述
     */
    private String content;


}
