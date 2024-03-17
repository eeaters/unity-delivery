package io.eeaters.delivery.shunfeng.convert;

import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.request.CallBackDeliveryReq;
import io.eeaters.delivery.shunfeng.enums.SFDeliveryStatus;
import io.eeaters.delivery.shunfeng.request.SFCallbackStatusReq;

public interface SFToCallBackDeliveryReqConverter {


    static CallBackDeliveryReq convert(SFCallbackStatusReq callbackStatusReq) {
        CallBackDeliveryReq result = new CallBackDeliveryReq();
        result.setChannelEnum(DeliveryChannelEnum.SF);
        result.setRiderPhone(callbackStatusReq.getOperatorPhone());
        result.setRiderName(callbackStatusReq.getOperatorName());
        result.setDeliveryCode(callbackStatusReq.getShopOrderId());
        result.setChannelOrderId(callbackStatusReq.getSfOrderId());
        result.setStatusEnum(SFDeliveryStatus.of(
                callbackStatusReq.getOrderStatus(), callbackStatusReq.getReceiptType()
        ).getStatusEnum());
        result.setStoreCode(callbackStatusReq.getShopId());
        return result;
    }
}
