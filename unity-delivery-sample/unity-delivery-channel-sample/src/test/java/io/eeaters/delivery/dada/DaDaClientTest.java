package io.eeaters.delivery.dada;

import io.eeaters.delivery.core.enums.CancelReasonEnum;
import io.eeaters.delivery.core.request.CancelDeliveryReq;
import io.eeaters.delivery.core.request.QueryDeliveryInfoReq;
import io.eeaters.delivery.core.request.QueryRiderPositionReq;
import io.eeaters.delivery.core.response.*;
import io.eeaters.delivery.mockito.CreateDeliveryReqMock;
import org.junit.Assert;
import org.junit.Test;

import static io.eeaters.delivery.mockito.AccountMock.mockDaDa;

public class DaDaClientTest {


    @Test
    public void cityCodeTest() {
        DaDaClient daDaClient = new DaDaClient();
        String shanghai = daDaClient.cityNameToCityCode(mockDaDa(),"上海");
        Assert.assertEquals(shanghai, "021");

        String beijing = daDaClient.cityNameToCityCode(mockDaDa(),"北京");
        Assert.assertEquals(beijing, "010");

        String guangzhou = daDaClient.cityNameToCityCode(mockDaDa(),"广州");
        Assert.assertEquals(guangzhou, "020");
    }

    @Test
    public void pre() {
        PreDeliveryResp preDelivery = new DaDaClient().createPreDelivery(mockDaDa(), CreateDeliveryReqMock.dada());
        Assert.assertNotNull(preDelivery);
    }



    @Test
    public void createDelivery() {
        CreateDeliveryResp preDeliveryResp = new DaDaClient()
                .createDelivery(mockDaDa(), CreateDeliveryReqMock.dada());
        Assert.assertNotNull(preDeliveryResp);
    }

    @Test
    public void cancelDelivery() {
        CancelDeliveryReq req = new CancelDeliveryReq();
        req.setDeliveryCode("1709305666281");
        req.setCancelReasonEnum(CancelReasonEnum.CUSTOMER_CANCEL);
        req.setCancelReasonDesc("我不想要了");
        CancelDeliveryResp cancelDelivery = new DaDaClient().cancelDelivery(mockDaDa(), req);
        Assert.assertNotNull(cancelDelivery);
    }

    @Test
    public void queryDelivery() {
        QueryDeliveryInfoReq queryDeliveryInfoReq = new QueryDeliveryInfoReq();
        queryDeliveryInfoReq.setDeliveryCode("1709305666281");
        QueryDeliveryInfoResp resp = new DaDaClient().queryDeliveryInfo(mockDaDa(), queryDeliveryInfoReq);
        Assert.assertNotNull(resp);
    }

    @Test
    public void riderPosition() {
        QueryRiderPositionReq riderPositionReq = new QueryRiderPositionReq();
        riderPositionReq.setDeliveryCode("1709305666281");
        QueryRiderPositionResp result = new DaDaClient().queryRiderPosition(mockDaDa(), riderPositionReq);
        Assert.assertNotNull(result);
    }

}
