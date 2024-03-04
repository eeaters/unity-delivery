package io.eeaters.delivery.core;

import io.eeaters.delivery.core.request.CancelDeliveryReq;
import io.eeaters.delivery.core.request.CreateDeliveryReq;
import io.eeaters.delivery.core.request.QueryDeliveryInfoReq;
import io.eeaters.delivery.core.request.QueryRiderPositionReq;
import io.eeaters.delivery.core.response.*;

public interface ChannelClient {

    PreDeliveryResp createPreDelivery(Account account, CreateDeliveryReq createDeliveryReq);

    CreateDeliveryResp createDelivery(Account account, CreateDeliveryReq createDeliveryReq);

    CancelDeliveryResp cancelDelivery(Account account, CancelDeliveryReq cancelDeliveryReq);

    QueryDeliveryInfoResp queryDeliveryInfo(Account account, QueryDeliveryInfoReq queryDeliveryInfoReq);

    QueryRiderPositionResp queryRiderPosition(Account account, QueryRiderPositionReq queryRiderPositionReq);
}
