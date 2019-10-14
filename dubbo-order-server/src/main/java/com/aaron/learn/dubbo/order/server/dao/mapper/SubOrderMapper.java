package com.aaron.learn.dubbo.order.server.dao.mapper;

import com.aaron.learn.base.mapper.CoreMapper;
import com.aaron.learn.dubbo.order.server.dao.po.SubOrder;

import java.util.List;

//@Mapper
public interface SubOrderMapper extends CoreMapper<SubOrder, Long> {

    List<SubOrder> selectByOrderNumber(String orderNumber);

}