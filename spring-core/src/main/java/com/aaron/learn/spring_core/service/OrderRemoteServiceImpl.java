package com.aaron.learn.spring_core.service;

import com.aaron.learn.base.util.ObjectClone;
import com.aaron.learn.dubbo.all.api.model.OrderDTO;
import com.aaron.learn.dubbo.all.api.service.OrderRemoteService;
import com.aaron.learn.spring_core.dao.mapper.OrderMapper;
import com.aaron.learn.spring_core.dao.po.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:33 2019/7/31
 * @Modiflid By:
 */
@Service
@Slf4j
public class OrderRemoteServiceImpl implements OrderRemoteService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderDTO getOrderInfo(OrderDTO orderDTO) throws Exception {
        Order order = orderMapper.selectInfoBySelective(ObjectClone.copy(orderDTO,Order.class));
        return ObjectClone.copy(order,OrderDTO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(OrderDTO orderDTO) throws Exception {
        int updateSum = orderMapper.updateByPrimaryKeySelective(ObjectClone.copy(orderDTO,Order.class));
        return updateSum/0 > 0;
    }

}
