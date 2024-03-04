package io.eeaters.delivery.shunfeng.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SFCreateDeliveryReq {

    @JsonProperty("dev_id")
    private Integer devId;

    @JsonProperty("shop_id")
    private String shopId;

    @JsonProperty("shop_type")
    private Integer shopType;

    @JsonProperty("shop_order_id")
    private String shopOrderId;

    @JsonProperty("order_source")
    private String orderSource;

    @JsonProperty("order_time")
    private Integer orderTime;

    @JsonProperty("push_time")
    private Integer pushTime;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("receive")
    private Receive receive;

    @JsonProperty("order_detail")
    private OrderDetail orderDetail;

    @Data
    public static class Receive {

        @JsonProperty("user_name")
        private String userName;

        @JsonProperty("user_phone")
        private String userPhone;

        @JsonProperty("user_address")
        private String userAddress;

        @JsonProperty("user_lng")
        private String userLng;

        @JsonProperty("user_lat")
        private String userLat;

    }

    @Data
    public static class OrderDetail {

        @JsonProperty("total_price")
        private Integer totalPrice;

        @JsonProperty("product_type")
        private Integer productType;

        @JsonProperty("weight_gram")
        private Integer weightGram;

        @JsonProperty("product_num")
        private Integer productNum;

        @JsonProperty("product_type_num")
        private Integer productTypeNum;

        @JsonProperty("product_detail")
        private List<ProductDetail> productDetail;

    }

    @Data
    public static class ProductDetail {

        @JsonProperty("product_name")
        private String productName;

        @JsonProperty("product_num")
        private Integer productNum;

    }
}
