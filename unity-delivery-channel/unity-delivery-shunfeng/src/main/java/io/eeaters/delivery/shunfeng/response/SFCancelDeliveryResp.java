package io.eeaters.delivery.shunfeng.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SFCancelDeliveryResp {
    /**
     * 顺丰订单号，新版本V1.9+升级为JS开头的15位字符串类型，老版本为int类型
     */
    @JsonProperty("sf_order_id")
    private String sfOrderId;

    /**
     * 商家订单号
     */
    @JsonProperty("shop_order_id")
    private String shopOrderId;

    /**
     * 扣款详情
     */
    @JsonProperty("deduction_detail")
    private DeductionDetail deductionDetail;

    /**
     * 接口返回时间（秒级时间戳）
     */
    @JsonProperty("push_time")
    private Integer pushTime;

    @Data
    public static class DeductionDetail {
        /**
         * 取消收费金额（单位：分）
         */
        @JsonProperty("deduction_fee")
        private Integer deductionFee;

        /**
         * 店铺维度累计的取消次数
         */
        @JsonProperty("shop_cancel_times")
        private Integer shopCancelTimes;

        /**
         * 配置的免费取消次数
         */
        @JsonProperty("free_cancel_times")
        private Integer freeCancelTimes;
    }
}
