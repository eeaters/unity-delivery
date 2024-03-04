package io.eeaters.delivery.shunfeng.convert;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.request.CreateDeliveryReq;
import io.eeaters.delivery.shunfeng.SFConstants;
import io.eeaters.delivery.shunfeng.request.SFCreateDeliveryReq;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static io.eeaters.delivery.core.util.UnitUtils.localDateTimeToSecond;

public interface SFCreateDeliveryReqConverter {

    static SFCreateDeliveryReq convert(CreateDeliveryReq createDeliveryReq, Account account) {
        SFCreateDeliveryReq deliveryReq = new SFCreateDeliveryReq();
        deliveryReq.setReceive(convertReceive(createDeliveryReq.getUserInformation()));
        deliveryReq.setOrderDetail(convertOrder(createDeliveryReq, account.getProductType()));
        Optional.ofNullable(account.getAppId()).map(Integer::valueOf).ifPresent(deliveryReq::setDevId);
        deliveryReq.setShopId(createDeliveryReq.getStoreCode());
        deliveryReq.setShopOrderId(String.valueOf(createDeliveryReq.getDeliveryCode()));

        deliveryReq.setShopType(SFConstants.SHOP_TYPE);
        deliveryReq.setOrderTime(localDateTimeToSecond(createDeliveryReq.getOrderTime()));
        deliveryReq.setVersion(SFConstants.VERSION);
        deliveryReq.setPushTime(Math.toIntExact(Instant.now().getEpochSecond()));
        deliveryReq.setOrderSource(createDeliveryReq.getOrderSource());
        return deliveryReq;
    }

    static SFCreateDeliveryReq.Receive convertReceive(CreateDeliveryReq.ContractInformation userInformation) {
        SFCreateDeliveryReq.Receive receive = new SFCreateDeliveryReq.Receive();
        receive.setUserAddress(userInformation.getContractUser());
        receive.setUserLng(String.valueOf(userInformation.getLongitude()));
        receive.setUserLat(String.valueOf(userInformation.getLatitude()));
        receive.setUserPhone(userInformation.getContractPhone());
        receive.setUserName(userInformation.getContractUser());
        return receive;
    }
    static SFCreateDeliveryReq.OrderDetail convertOrder(CreateDeliveryReq req, Integer productType) {
        AtomicInteger productNum = new AtomicInteger(0);

        List<SFCreateDeliveryReq.ProductDetail> productDetails = req.getProductInfoList()
                .stream()
                .peek(info -> {
                    productNum.addAndGet(info.getProductNum());
                })
                .map(SFCreateDeliveryReqConverter::convertProduct)
                .toList();

        SFCreateDeliveryReq.OrderDetail orderDetail = new SFCreateDeliveryReq.OrderDetail();
        orderDetail.setProductType(productType);
        orderDetail.setProductDetail(productDetails);
        orderDetail.setProductNum(productNum.get());
        orderDetail.setWeightGram(req.getWeightGram());
        orderDetail.setTotalPrice(req.getTotalPrice());
        orderDetail.setProductTypeNum(productDetails.size());
        orderDetail.setProductDetail(productDetails);
        return orderDetail;
    }


    static SFCreateDeliveryReq.ProductDetail convertProduct(CreateDeliveryReq.ProductInfo productInfo) {
        SFCreateDeliveryReq.ProductDetail productDetail = new SFCreateDeliveryReq.ProductDetail();
        productDetail.setProductName(productInfo.getProductName());
        productDetail.setProductNum(productDetail.getProductNum());
        return productDetail;
    }
}
