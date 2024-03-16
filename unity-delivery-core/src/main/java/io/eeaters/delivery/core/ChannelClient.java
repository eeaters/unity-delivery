package io.eeaters.delivery.core;

import io.eeaters.delivery.core.enums.DeliveryChannelEnum;
import io.eeaters.delivery.core.request.*;
import io.eeaters.delivery.core.response.*;

public interface ChannelClient {

    /**
     * 预下单接口 ， 适用于预估运费/预计送达时间
     * @param account 账号
     * @param createDeliveryReq 运单信息
     * @return 三方预估信息
     */
    PreDeliveryResp createPreDelivery(Account account, CreateDeliveryReq createDeliveryReq);

    /**
     * 下单接口， 适用于真实下单
     * @param account 账号
     * @param createDeliveryReq 运单信息
     * @return 下单响应
     */
    CreateDeliveryResp createDelivery(Account account, CreateDeliveryReq createDeliveryReq);

    /**
     * 取消接口， 适用于 商家及客户主动取消/系统长时间未接单判定的超时取消
     * @param account 账号
     * @param cancelDeliveryReq
     * @return
     */
    CancelDeliveryResp cancelDelivery(Account account, CancelDeliveryReq cancelDeliveryReq);

    /**
     * 查询运单信息， 适用于异常情况下的数据补偿
     * @param account 账号
     * @param queryDeliveryInfoReq params
     * @return 运单信息
     */
    QueryDeliveryInfoResp queryDeliveryInfo(Account account, QueryDeliveryInfoReq queryDeliveryInfoReq);

    /**
     * 查询骑手实时位置， 适用于运单完成前，主动查询骑手实时轨迹
     * @param account 账号
     * @param queryRiderPositionReq params
     * @return 骑手位置
     */
    QueryRiderPositionResp queryRiderPosition(Account account, QueryRiderPositionReq queryRiderPositionReq);





    /**
     * 适用渠道
     * @return 当前Client适用的渠道
     */
    DeliveryChannelEnum supportChannel();


}
