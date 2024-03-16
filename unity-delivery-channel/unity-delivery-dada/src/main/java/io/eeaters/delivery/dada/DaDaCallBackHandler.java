package io.eeaters.delivery.dada;

import io.eeaters.delivery.core.CallBackContext;
import io.eeaters.delivery.core.CallBackHandler;
import io.eeaters.delivery.core.DeliveryRelateAccountLookUp;
import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.request.CallBackDeliveryReq;
import io.eeaters.delivery.core.util.JsonUtils;
import io.eeaters.delivery.core.util.MapUtils;
import io.eeaters.delivery.dada.convert.DaDaToCallBackDeliveryReqConverter;
import io.eeaters.delivery.dada.request.DaDaStatusCallBackReq;

import java.util.Map;

public class DaDaCallBackHandler implements CallBackHandler {
    static final Map<String, Object> success = MapUtils.initSingleEntryMap("code", 200);

    static final Map<String, Object> failure = MapUtils.initSingleEntryMap("code", 0);


    @Override
    public CallBackDeliveryReq handlerCallBack(String callBackStr, String sign,
                                               DeliveryRelateAccountLookUp accountLookUp) {
        DaDaStatusCallBackReq callBackReq = JsonUtils.readValue(callBackStr, DaDaStatusCallBackReq.class);

        assert callBackReq != null;
        CallBackDeliveryReq deliveryReq = DaDaToCallBackDeliveryReqConverter.convert(callBackReq);
        deliveryReq.setSignVerify(DaDaSignGenerate.verify(callBackReq));
        return deliveryReq;
    }

    @Override
    public Object generate(Boolean verify) {
        return verify ? success : failure;
    }


    @Override
    public DeliveryChannelEnum supportChannel() {
        return DeliveryChannelEnum.DADA;
    }

}
