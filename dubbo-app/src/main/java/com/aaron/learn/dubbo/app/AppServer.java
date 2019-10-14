package com.aaron.learn.dubbo.app;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:03 2019/9/29
 * @Modiflid By:
 */
@EnableDubbo
@SpringBootApplication
// 使用 dubbo.xml 配置
@ImportResource(value = {"classpath:dubbo.xml"})
public class AppServer {

    public static void main(String[] args) {
        SpringApplication.run(AppServer.class);
    }

}
