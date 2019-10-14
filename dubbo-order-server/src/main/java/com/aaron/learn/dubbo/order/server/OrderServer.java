package com.aaron.learn.dubbo.order.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:01 2019/9/28
 * @Modiflid By:
 */
@SpringBootApplication
@MapperScan("com.aaron.learn.dubbo.order.server.dao.mapper")
public class OrderServer {
    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class,args);
    }
}
