package io.eeaters.delivery.core;

import io.eeaters.delivery.core.enums.EnvEnum;
import lombok.Data;

@Data
public class Account {

    private String callback;

    private String appId;

    private String appKey;

    private String appSecret;

    private String callbackUrl;

    //商户id  -- 达达渠道需要使用该字段
    private String sourceId;

    //配送的商品类型。 通常来说客户送药都是送药，送餐都是送餐，送花都是送花。类型先放在账号上
    private Integer productType;

    private EnvEnum env = EnvEnum.QA;
}
