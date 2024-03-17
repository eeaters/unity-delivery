package io.eeaters.delivery.dada.convert;

import io.eeaters.delivery.core.enums.CancelReasonEnum;
import io.eeaters.delivery.core.request.CancelDeliveryReq;
import io.eeaters.delivery.dada.request.DaDaCancelDeliveryReq;

import static io.eeaters.delivery.core.enums.CancelReasonEnum.CUSTOMER_CANCEL;

public interface DaDaCancelDeliveryReqConverter {

    static DaDaCancelDeliveryReq convert(CancelDeliveryReq cancelDeliveryReq) {
        DaDaCancelDeliveryReq result = new DaDaCancelDeliveryReq();
        result.setOrderId(cancelDeliveryReq.getDeliveryCode());

        int cancelReasonId = cancelDeliveryReq.getCancelReasonEnum() == CUSTOMER_CANCEL ? 4 : 1000;
        result.setCancelReasonId(cancelReasonId);
        result.setCancelReason(cancelDeliveryReq.getCancelReasonDesc());
        return result;
    }
}
