package io.eeaters.delivery.dada;

import com.fasterxml.jackson.databind.JavaType;
import io.eeaters.delivery.core.response.PreDeliveryResp;
import io.eeaters.delivery.core.util.JsonUtils;
import io.eeaters.delivery.dada.response.*;
import lombok.Getter;

import java.util.List;

@Getter
enum DaDaUrlToRespTypeEnum {

    CITY_CODE("api/cityCode/list", null) {
        @Override
        public JavaType getResponseType() {
            JavaType listType = JsonUtils.objectMapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, DaDaCityCodeResp.class);
            return JsonUtils.objectMapper.getTypeFactory()
                    .constructParametricType(DaDaBaseResponse.class, listType);
        }
    },


    PRE_ORDER("api/order/queryDeliverFee", JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(DaDaBaseResponse.class, DaDaPreDeliveryResp.class)
    ),


    CREATE_ORDER("api/order/addOrder", JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(DaDaBaseResponse.class, DaDaCreateDeliveryResp.class)),

    CANCEL_ORDER("api/order/formalCancel", JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(DaDaBaseResponse.class, DaDaCancelDeliveryResp.class)),

    QUERY_ORDER("api/order/status/query",  JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(DaDaBaseResponse.class, DaDaQueryDeliveryResp.class)),

    QUERY_RIDER("api/order/transporter/position", null){
        @Override
        public JavaType getResponseType() {
            JavaType listType = JsonUtils.objectMapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, DaDaQueryRiderPositionResp.class);
            return JsonUtils.objectMapper.getTypeFactory()
                    .constructParametricType(DaDaBaseResponse.class, listType);
        }
    },
    ;

    private String url;

    private JavaType responseType;

    DaDaUrlToRespTypeEnum(String url, JavaType responseType) {
        this.url = url;
        this.responseType = responseType;
    }

}
