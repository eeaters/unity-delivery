package io.eeaters.delivery.meituan.convert;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.enums.CoordinateTypeEnum;
import io.eeaters.delivery.core.enums.OrderTypeEnum;
import io.eeaters.delivery.core.request.CreateDeliveryReq;
import io.eeaters.delivery.meituan.request.CreatePreMtDeliveryReq;

import java.time.ZoneOffset;

import static io.eeaters.delivery.meituan.enums.ServiceCodeEnum.JI_SHI;

public interface CreatePreMtDeliveryReqConverter {

    static CreatePreMtDeliveryReq convert(CreateDeliveryReq createDeliveryReq, Account account) {
        CreatePreMtDeliveryReq deliveryReq = new CreatePreMtDeliveryReq();
        deliveryReq.setDeliveryId(createDeliveryReq.getDeliveryCode());
        deliveryReq.setOrderId(String.valueOf(createDeliveryReq.getDeliveryCode()));
        deliveryReq.setShopId(createDeliveryReq.getStoreCode());
        deliveryReq.setDeliveryServiceCode(JI_SHI.getCode());
        deliveryReq.setReceiverName(createDeliveryReq.getUserInformation().getContractUser());
        deliveryReq.setReceiverAddress(createDeliveryReq.getUserInformation().getAddress());
        deliveryReq.setReceiverPhone(createDeliveryReq.getUserInformation().getContractPhone());

        Integer lng = (int) (createDeliveryReq.getUserInformation().getLongitude() * Math.pow(10, 6));
        Integer lat = (int) (createDeliveryReq.getUserInformation().getLatitude() * Math.pow(10, 6));
        deliveryReq.setReceiverLng(lng);
        deliveryReq.setReceiverLat(lat);


        deliveryReq.setCoordinateType(createDeliveryReq.getCoordinate() == CoordinateTypeEnum.GCJ_02 ? 0 : 1);
        deliveryReq.setGoodsValue(createDeliveryReq.getTotalPrice() / 100.0);
        deliveryReq.setGoodsHeight(null);
        deliveryReq.setGoodsWeight(createDeliveryReq.getWeightGram() / 1000.0);
        deliveryReq.setGoodsLength(null);
        deliveryReq.setGoodsDetail(null);
        deliveryReq.setGoodsPickupInfo(null);
        deliveryReq.setGoodsDeliveryInfo(null);
        deliveryReq.setExpectedPickupTime(null);
        deliveryReq.setExpectedDeliveryTime(createDeliveryReq.getExceptDeliveryTime().toEpochSecond(ZoneOffset.UTC));
        deliveryReq.setOrderType(createDeliveryReq.getOrderType() == OrderTypeEnum.REAL_TIME_ORDER ? 0 : 1);
        deliveryReq.setPoiSeq(null);
        deliveryReq.setNote(null);
        deliveryReq.setCashOnDelivery(null);
        deliveryReq.setCashOnPickup(null);
        deliveryReq.setInvoiceTitle(null);
        deliveryReq.setPayTypeCode(100);

        deliveryReq.setOuterOrderSourceDesc("placeholder");
        // 当单子是美团外卖的单子； 会需要设值
        deliveryReq.setOuterOrderSourceNo(null);
        return deliveryReq;
    }

}
