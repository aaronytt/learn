package com.aaron.learn.dubbo.order.server.service;

import com.aaron.learn.base.util.ObjectClone;
import com.aaron.learn.dubbo.all.api.service.OrderRemoteService;
import com.aaron.learn.dubbo.order.server.dao.mapper.OrderMapper;
import com.aaron.learn.dubbo.order.server.dao.po.Order;
import com.aaron.learn.dubbo.all.api.model.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:33 2019/7/31
 * @Modiflid By:
 */
@Service(interfaceClass = OrderRemoteService.class)
@Slf4j
public class OrderRemoteServiceImpl implements OrderRemoteService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderDTO getOrderInfo(OrderDTO orderDTO) throws Exception {
        Order order = orderMapper.selectInfoBySelective(ObjectClone.copy(orderDTO,Order.class));
        return ObjectClone.copy(order,OrderDTO.class);
    }

}
