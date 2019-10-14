package com.aaron.learn.dubbo.app.controller;

import com.aaron.learn.dubbo.all.api.service.OrderRemoteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:55 2019/9/28
 * @Modiflid By:
 */
@RestController
@RequestMapping("app/order")
public class OrderController {

    @Reference
    OrderRemoteService orderRemoteService;

}
