package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.Order;
import com.zpc.mybatis.pojo.OrderUser;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    OrderUser queryOrderUserByOrderNumber(@Param("number") String number);

    /**
     * 根据订单号查询订单用户信息以及订单详情
     * @param number
     * @return
     */
    Order queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);

    Order queryOrderWithUserAndDetailItemByOrderNumber(@Param("number") String number);

    /**
     *
     * @param number
     * @return
     */
    public Order queryOrderAndUserByOrderNumberLazy(@Param("number") String number);

}
