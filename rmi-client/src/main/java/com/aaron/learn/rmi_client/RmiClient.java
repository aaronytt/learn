package com.aaron.learn.rmi_client;

import com.aaron.learn.rmi_server.service.OrderService;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:08 2019/9/28
 * @Modiflid By:
 */
public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //通过RMI发现服务并且转换成一个对象
        OrderService orderService = (OrderService) Naming.lookup("rmi://localhost:8080/order");
        //远程调用
        System.out.println(orderService.createOrder("20180505030102", BigDecimal.valueOf(100.01)));

    }

}
