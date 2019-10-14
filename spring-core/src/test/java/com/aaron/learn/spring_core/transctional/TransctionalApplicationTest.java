package com.aaron.learn.spring_core.transctional;

import com.aaron.learn.dubbo.all.api.model.OrderDTO;
import com.aaron.learn.dubbo.all.api.service.OrderRemoteService;
import com.aaron.learn.spring_core.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:31 2019/10/8
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransctionalApplicationTest {
    @Autowired
    OrderRemoteService orderRemoteService;

    @Test
    public void transctionalTest(){
        try {
            orderRemoteService.update(OrderDTO.builder().id(2l).amount(BigDecimal.valueOf(211.01)).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
