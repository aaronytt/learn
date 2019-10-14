package com.aaron.learn.rmi_server.service;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:37 2019/9/28
 * @Modiflid By:
 */
public interface OrderService extends Remote {

    String createOrder(String orderId, BigDecimal amount) throws RemoteException;

}
