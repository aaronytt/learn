package com.aaron.learn.spring_core.aop;

import com.aaron.learn.spring_core.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:31 2019/10/8
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AOPDemoApplicationTest {
    @Autowired
    Car car;

    @Test
    public void aopTest(){
        car.drive("dazhong");
    }

}
