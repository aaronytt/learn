package com.aaron.learn.dubbo.all.api.service;

import com.aaron.learn.dubbo.all.api.model.OrderDTO;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:33 2019/7/31
 * @Modiflid By:
 */
public interface OrderRemoteService {

    OrderDTO getOrderInfo(OrderDTO order) throws Exception;

    boolean update(OrderDTO orderDTO) throws Exception;

}
