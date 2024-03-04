package io.eeaters.delivery.shunfeng.convert;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.request.QueryRiderPositionReq;
import io.eeaters.delivery.core.util.UnitUtils;
import io.eeaters.delivery.shunfeng.SFConstants;
import io.eeaters.delivery.shunfeng.request.SFQueryRiderPositionReq;

import java.time.LocalDateTime;

public interface SFQueryRiderPositionReqConverter {

    static SFQueryRiderPositionReq convert(Account account, QueryRiderPositionReq req) {
        SFQueryRiderPositionReq result = new SFQueryRiderPositionReq();
        result.setDevId(Integer.valueOf(account.getAppId()));
        result.setOrderType(2);
        result.setShopId(req.getStoreCode());
        result.setShopType(SFConstants.SHOP_TYPE);
        result.setOrderId(req.getDeliveryCode());
        result.setPushTime(UnitUtils.localDateTimeToSecond(LocalDateTime.now()));
        return result;
    }

}
