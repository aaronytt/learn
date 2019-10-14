package com.aaron.learn.spring_core.dao.mapper;

import com.aaron.learn.base.mapper.CoreMapper;
import com.aaron.learn.spring_core.dao.po.Order;

//@Mapper
public interface OrderMapper extends CoreMapper<Order, Long> {

    Order selectInfoBySelective(Order order);

}