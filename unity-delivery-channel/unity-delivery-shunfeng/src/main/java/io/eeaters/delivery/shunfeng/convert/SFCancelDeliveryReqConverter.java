package io.eeaters.delivery.shunfeng.convert;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.request.CancelDeliveryReq;
import io.eeaters.delivery.shunfeng.SFConstants;
import io.eeaters.delivery.shunfeng.request.SFCancelDeliveryReq;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;

import static io.eeaters.delivery.core.util.UnitUtils.localDateTimeToSecond;

public interface SFCancelDeliveryReqConverter {

    static SFCancelDeliveryReq convert(CancelDeliveryReq req, Account account) {
        SFCancelDeliveryReq result = new SFCancelDeliveryReq();
        result.setDevId(Integer.valueOf(account.getAppId()));
        result.setShopType(SFConstants.SHOP_TYPE);
        result.setShopId(req.getStoreCode());
        result.setCancelReason(req.getCancelReasonDesc());
        result.setPushTime(localDateTimeToSecond(LocalDateTime.now()));
        if (StringUtils.isNotBlank(req.getDeliveryCode())) {
            result.setOrderType(2);
            result.setOrderId(req.getDeliveryCode());
        }else{
            result.setOrderType(1);
            result.setOrderId(req.getChannelOrderId());
        }
        return result;
    }
}
