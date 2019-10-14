package com.aaron.learn.rmi_server.service;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:40 2019/9/28
 * @Modiflid By:
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService {

    public OrderServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String createOrder(String orderId, BigDecimal amount) throws RemoteException {

        System.out.println("orderId: " + orderId + ", amount: " + amount);

        return "orderId: " + orderId + ", status: OK";
    }

}
