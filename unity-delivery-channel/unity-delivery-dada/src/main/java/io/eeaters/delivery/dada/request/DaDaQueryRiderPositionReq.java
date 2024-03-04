package io.eeaters.delivery.dada.request;

import lombok.Data;

import java.util.List;

@Data
public class DaDaQueryRiderPositionReq {

    /**
     * 	第三方订单号列表,最多传50个
     */
    private List<String> orderIds;

}
