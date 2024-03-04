package io.eeaters.delivery.core.response;

import lombok.Data;

@Data
public class QueryRiderPositionResp{
    //骑手名字
    private String riderName;
    //骑手手机号
    private String riderPhone;
    //骑手经度
    private Double riderLng;
    //骑手纬度
    private Double riderLat;

}
