package com.aaron.learn.spring_core.test.init_destory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 1:44 2019/10/18
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InitDestoryDemoApplication.class)
public class InitDestoryDemotest {

    public static void main(String[] args) {
        SpringApplication.run(InitDestoryDemotest.class);
    }

    @Autowired
    InitDestoryDemo initDestoryDemo;

    @Test
    public void test(){
        initDestoryDemo.demo();
    }

}
