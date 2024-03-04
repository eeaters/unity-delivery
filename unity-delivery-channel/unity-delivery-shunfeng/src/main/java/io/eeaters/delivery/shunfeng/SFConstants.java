package io.eeaters.delivery.shunfeng;

public interface SFConstants {

    Integer PRODUCT_TYPE = 10;

    //门店类型 1：顺丰店铺ID ；2：接入方店铺ID
    Integer SHOP_TYPE = 2;

    //返回所有信息
    Integer RETURN_FLAG = 511;

    //版本号；doc中写死的
    Integer VERSION = 19;

    String  URL_PREFIX = "https://openic.sf-express.com/";

    String PRE_ORDER_SUFFIX = "open/api/external/precreateorder";
}
