package io.eeaters.delivery.dada.convert;

import io.eeaters.delivery.core.request.CallBackDeliveryReq;
import io.eeaters.delivery.dada.enums.DaDaDeliveryStatus;
import io.eeaters.delivery.dada.request.DaDaStatusCallBackReq;

import java.util.Objects;

public interface DaDaToCallBackDeliveryReqConverter {

    static CallBackDeliveryReq convert(DaDaStatusCallBackReq callBackReq) {
        CallBackDeliveryReq result = new CallBackDeliveryReq();
        result.setDeliveryCode(callBackReq.getOrderId());
        result.setDeliveryCode(callBackReq.getClientId());
        result.setStatusEnum(
                Objects.requireNonNull(DaDaDeliveryStatus.of(callBackReq.getOrderStatus())).getStatusEnum()
        );
        result.setRiderName(callBackReq.getDmName());
        result.setRiderPhone(callBackReq.getDmMobile());
        return result;
    }

}
