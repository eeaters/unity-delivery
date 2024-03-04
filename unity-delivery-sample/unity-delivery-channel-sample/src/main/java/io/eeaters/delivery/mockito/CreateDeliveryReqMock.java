package io.eeaters.delivery.mockito;

import io.eeaters.delivery.core.request.CreateDeliveryReq;

import java.time.LocalDateTime;
import java.util.List;

public interface CreateDeliveryReqMock {

    static CreateDeliveryReq sf() {

        CreateDeliveryReq createDeliveryDTO = new CreateDeliveryReq();
        createDeliveryDTO.setStoreCode("999999");
        createDeliveryDTO.setWeightGram(10);
        createDeliveryDTO.setOrderSource("配送测试");

        CreateDeliveryReq.ContractInformation information = new CreateDeliveryReq.ContractInformation();
        information.setLatitude(40.030613);
        information.setLongitude(116.354787);
        information.setAddress("海淀区清河龙岗路51号清润家园小区 永辉");
        information.setContractUser("eeaters");
        information.setContractPhone("13333333333");
        createDeliveryDTO.setUserInformation(information);

        //pre 之前的参数已经够了
        CreateDeliveryReq.ProductInfo productInfo = new CreateDeliveryReq.ProductInfo();
        productInfo.setProductName("测试商品");
        productInfo.setProductNum(1);
        createDeliveryDTO.setProductInfoList(List.of(productInfo));
        createDeliveryDTO.setTotalPrice(1200);

        createDeliveryDTO.setDeliveryCode(System.currentTimeMillis());
        createDeliveryDTO.setOrderTime(LocalDateTime.now().minusMinutes(1));
        return createDeliveryDTO;
    }


    static CreateDeliveryReq dada() {
        CreateDeliveryReq deliveryReq = sf();
        deliveryReq.setStoreCode("2a8e293e5f294b5c");
        deliveryReq.getUserInformation().setLatitude(31.257801);
        deliveryReq.getUserInformation().setLongitude(121.538842);
        deliveryReq.getUserInformation().setAddress("东方渔人码头");
        return deliveryReq;
    }

}
