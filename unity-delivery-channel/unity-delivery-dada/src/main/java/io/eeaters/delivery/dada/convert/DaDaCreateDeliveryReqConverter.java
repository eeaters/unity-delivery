package io.eeaters.delivery.dada.convert;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.request.CreateDeliveryReq;
import io.eeaters.delivery.core.util.UnitUtils;
import io.eeaters.delivery.dada.request.DaDaCreateDeliveryReq;

public interface DaDaCreateDeliveryReqConverter {

    static DaDaCreateDeliveryReq convert(CreateDeliveryReq deliveryReq, Account account) {
        DaDaCreateDeliveryReq result = new DaDaCreateDeliveryReq();
        result.setCallback(account.getCallback());
        result.setShopNo(deliveryReq.getStoreCode());
        result.setOriginId(String.valueOf(deliveryReq.getDeliveryCode()));
        result.setCargoPrice(UnitUtils.fenToYuan(deliveryReq.getTotalPrice()));
        result.setCargoWeight(UnitUtils.gToKg(deliveryReq.getWeightGram()));
        result.setIsPrepay(0);
        result.setReceiverAddress(deliveryReq.getUserInformation().getAddress());
        result.setReceiverLng(deliveryReq.getUserInformation().getLongitude());
        result.setReceiverLat(deliveryReq.getUserInformation().getLatitude());
        result.setReceiverName(deliveryReq.getUserInformation().getContractUser());
        result.setReceiverPhone(deliveryReq.getUserInformation().getContractPhone());
        return result;
    }
}
