package com.aaron.learn.spring_core.test.aop;

import com.aaron.learn.spring_core.test.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    /**
     * Autowired按照类型注入，可以注入空
     *
     * Resource默认按照类型，指定名字按照名字
     *
     * Inject 需要POM.XML额外引用javax.inject, 和Autowired差不多，支持@Primary，不支持required
     *
     */
    @Autowired
//    @Resource
//    @Inject
    Car car;

    @Test
    public void aopTest(){
        car.drive("dazhong");
    }

}
