package com.aaron.learn.dubbo.app.test;

import com.aaron.learn.dubbo.app.AppServer;
import com.aaron.learn.dubbo.all.api.service.ProductRemoteService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:11 2019/9/29
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServer.class)
public class StartTest {

    @Reference
    ProductRemoteService productRemoteService;

    @Test
    public void test(){
        System.out.println(productRemoteService.getInfoById(1l));
    }

}
