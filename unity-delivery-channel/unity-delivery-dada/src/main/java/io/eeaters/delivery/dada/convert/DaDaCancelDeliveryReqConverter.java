package io.eeaters.delivery.dada.convert;

import io.eeaters.delivery.core.request.CancelDeliveryReq;
import io.eeaters.delivery.dada.request.DaDaCancelDeliveryReq;

public interface DaDaCancelDeliveryReqConverter {

    static DaDaCancelDeliveryReq convert(CancelDeliveryReq cancelDeliveryReq) {
        DaDaCancelDeliveryReq result = new DaDaCancelDeliveryReq();
        result.setOrderId(cancelDeliveryReq.getDeliveryCode());
        Integer cancelReasonId = switch (cancelDeliveryReq.getCancelReasonEnum()) {
            case CUSTOMER_CANCEL -> 4;
            default -> 1000;
        };
        result.setCancelReasonId(cancelReasonId);
        result.setCancelReason(cancelDeliveryReq.getCancelReasonDesc());
        return result;
    }
}
