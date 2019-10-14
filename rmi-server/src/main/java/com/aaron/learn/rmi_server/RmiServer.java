package com.aaron.learn.rmi_server;

import com.aaron.learn.rmi_server.service.OrderService;
import com.aaron.learn.rmi_server.service.OrderServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:41 2019/9/28
 * @Modiflid By:
 */
public class RmiServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        //本地服务
        OrderService orderService = new OrderServiceImpl();
        //本地服务注册到端口中
        LocateRegistry.createRegistry(8080);
        Naming.bind("rmi://localhost:8080/order", orderService);

        System.out.println("romote-server started...");
    }

}
