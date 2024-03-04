package io.eeaters.delivery.dada.response;

import lombok.Data;

@Data
public class DaDaQueryRiderPositionResp {

    /**
     * 第三方订单号
     */
    private String orderId;

    /**
     * 纬度
     */
    private String transporterLat;

    /**
     * 经度
     */
    private String transporterLng;

    /**
     * 骑士姓名
     */
    private String transporterName;

    /**
     * 骑士电话
     */
    private String transporterPhone;
}
