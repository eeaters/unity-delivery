package io.eeaters.delivery.shunfeng.convert;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.request.CreateDeliveryReq;
import io.eeaters.delivery.shunfeng.SFConstants;
import io.eeaters.delivery.shunfeng.request.SFPreDeliveryReq;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static io.eeaters.delivery.core.util.UnitUtils.localDateTimeToSecond;

public interface SFPreDeliveryReqConverter {

    static SFPreDeliveryReq convert(CreateDeliveryReq createDeliveryReq,
                                    Account account) {
        SFPreDeliveryReq request = new SFPreDeliveryReq();
        request.setDevId(Integer.valueOf(account.getAppId()));
        request.setShopId(createDeliveryReq.getStoreCode());
        request.setShopType(SFConstants.SHOP_TYPE);
        request.setProductType(SFConstants.PRODUCT_TYPE);
        request.setPushTime(localDateTimeToSecond(LocalDateTime.now()));
        request.setWeight(createDeliveryReq.getWeightGram());
        request.setUserLat(String.valueOf(createDeliveryReq.getUserInformation().getLatitude()));
        request.setUserLng(String.valueOf(createDeliveryReq.getUserInformation().getLongitude()));
        request.setUserAddress(createDeliveryReq.getUserInformation().getAddress());
        request.setReturnFlag(SFConstants.RETURN_FLAG);
        return request;

    }
}
