package com.aaron.learn.dubbo.order.server.dao.mapper;

import com.aaron.learn.base.mapper.CoreMapper;
import com.aaron.learn.dubbo.order.server.dao.po.Order;

//@Mapper
public interface OrderMapper extends CoreMapper<Order, Long> {

    Order selectInfoBySelective(Order order);

}