package io.eeaters.delivery.shunfeng;

import io.eeaters.delivery.core.request.CancelDeliveryReq;
import io.eeaters.delivery.core.request.QueryDeliveryInfoReq;
import io.eeaters.delivery.core.request.QueryRiderPositionReq;
import io.eeaters.delivery.core.response.CancelDeliveryResp;
import io.eeaters.delivery.core.response.CreateDeliveryResp;
import io.eeaters.delivery.core.response.PreDeliveryResp;
import io.eeaters.delivery.core.response.QueryDeliveryInfoResp;
import io.eeaters.delivery.mockito.AccountMock;
import io.eeaters.delivery.mockito.CreateDeliveryReqMock;
import org.junit.Assert;
import org.junit.Test;

import static io.eeaters.delivery.mockito.AccountMock.mockSF;

public class SFClientTest {

    @Test
    public void preDelivery() {
        PreDeliveryResp preDeliveryResp = new SFClient()
                .createPreDelivery(AccountMock.mockSF(), CreateDeliveryReqMock.sf());
        Assert.assertNotNull(preDeliveryResp);
    }

    @Test
    public void createDelivery() {
        CreateDeliveryResp preDeliveryResp = new SFClient()
                .createDelivery(mockSF(), CreateDeliveryReqMock.sf());
        Assert.assertNotNull(preDeliveryResp);
    }


    @Test
    public void cancelDelivery() {
        CancelDeliveryReq cancelDeliveryReq = new CancelDeliveryReq();
        cancelDeliveryReq.setChannelOrderId("JS4154306257366");
        cancelDeliveryReq.setCancelReasonDesc("不想要了");
        cancelDeliveryReq.setStoreCode("999999");
        CancelDeliveryResp cancelDelivery = new SFClient().cancelDelivery(mockSF(), cancelDeliveryReq);
        System.out.println("cancelDeliveryReq = " + cancelDelivery);

    }

    @Test
    public void queryDelivery() {
        QueryDeliveryInfoReq queryDeliveryInfoReq = new QueryDeliveryInfoReq();
        queryDeliveryInfoReq.setStoreCode("999999");
        QueryDeliveryInfoResp delivery = new SFClient().queryDeliveryInfo(mockSF(), queryDeliveryInfoReq);
        Assert.assertNotNull(delivery);
    }


    @Test
    public void riderPosition() {
        QueryRiderPositionReq riderPositionReq = new QueryRiderPositionReq();
        riderPositionReq.setStoreCode("999999");
        riderPositionReq.setChannelOrderId("JS4154306257366");
        new SFClient().queryRiderPosition(mockSF(), riderPositionReq);
    }

}
