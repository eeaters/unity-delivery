package io.eeaters.delivery.shunfeng.convert;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.request.QueryDeliveryInfoReq;
import io.eeaters.delivery.shunfeng.SFConstants;
import io.eeaters.delivery.shunfeng.request.SFQueryDeliveryInfoReq;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

import static io.eeaters.delivery.core.util.UnitUtils.localDateTimeToSecond;

public interface SFQueryDeliveryReqConverter {

    static SFQueryDeliveryInfoReq convert(QueryDeliveryInfoReq req, Account account) {
        SFQueryDeliveryInfoReq result = new SFQueryDeliveryInfoReq();
        result.setDevId(Integer.valueOf(account.getAppId()));
        result.setShopType(SFConstants.SHOP_TYPE);
        result.setShopId(req.getStoreCode());
        result.setOrderType(2);
        result.setOrderId(req.getDeliveryCode());
        result.setPushTime(localDateTimeToSecond(LocalDateTime.now()));
        return result;
    }
}
