package io.eeaters.delivery.meituan;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.ChannelClient;
import io.eeaters.delivery.core.request.CancelDeliveryReq;
import io.eeaters.delivery.core.request.CreateDeliveryReq;
import io.eeaters.delivery.core.request.QueryDeliveryInfoReq;
import io.eeaters.delivery.core.request.QueryRiderPositionReq;
import io.eeaters.delivery.core.response.*;
import io.eeaters.delivery.meituan.convert.CreatePreMtDeliveryReqConverter;
import io.eeaters.delivery.meituan.request.CreatePreMtDeliveryReq;

public class MTClient implements ChannelClient {


    @Override
    public PreDeliveryResp createPreDelivery(Account account, CreateDeliveryReq createDeliveryReq)  {
        CreatePreMtDeliveryReq mtDeliveryReq = CreatePreMtDeliveryReqConverter.convert(createDeliveryReq, account);
        //没有美团账号可以联调了 。。。
        return null;
    }

    @Override
    public CreateDeliveryResp createDelivery(Account account, CreateDeliveryReq createDeliveryReq) {
        return null;

    }

    @Override
    public CancelDeliveryResp cancelDelivery(Account account, CancelDeliveryReq cancelDeliveryReq) {
        return null;
    }

    @Override
    public QueryDeliveryInfoResp queryDeliveryInfo(Account account, QueryDeliveryInfoReq queryDeliveryInfoReq) {
        return null;
    }

    @Override
    public QueryRiderPositionResp queryRiderPosition(Account account, QueryRiderPositionReq queryRiderPositionReq) {
        return null;
    }

}
