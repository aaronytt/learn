package com.aaron.learn.spring_core.test.init_destory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 1:44 2019/10/18
 * @Modiflid By:
 */
@SpringBootApplication(scanBasePackages = {"com.aaron.learn.spring_core.test.init_destory"})
@ImportResource("classpath:InitDestoryDemo.xml")
public class InitDestoryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InitDestoryDemoApplication.class);
    }

}
