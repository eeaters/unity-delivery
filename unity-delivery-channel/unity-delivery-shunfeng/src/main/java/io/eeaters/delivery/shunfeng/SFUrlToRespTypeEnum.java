package io.eeaters.delivery.shunfeng;

import com.fasterxml.jackson.databind.JavaType;
import io.eeaters.delivery.core.util.JsonUtils;
import io.eeaters.delivery.shunfeng.response.*;
import lombok.Getter;

@Getter
public enum SFUrlToRespTypeEnum {

    PRE_ORDER("open/api/external/precreateorder", JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(SFBaseResponse.class, SFPreDeliveryResp.class)),

    CREATE_ORDER("open/api/external/createorder", JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(SFBaseResponse.class, SFCreateDeliveryResp.class)),

    CANCEL_ORDER("open/api/external/cancelorder", JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(SFBaseResponse.class, SFCancelDeliveryResp.class)),

    QUERY_ORDER("open/api/external/getorderstatus", JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(SFBaseResponse.class, SFQueryDeliveryResp.class)),

    QUERY_RIDER("open/api/external/riderlatestposition",JsonUtils.objectMapper.getTypeFactory()
            .constructParametricType(SFBaseResponse.class, SFQueryRiderPositionResp.class))

    ;
    private String url;

    private JavaType responseType;

    SFUrlToRespTypeEnum(String url, JavaType responseType) {
        this.url = url;
        this.responseType = responseType;
    }
}
