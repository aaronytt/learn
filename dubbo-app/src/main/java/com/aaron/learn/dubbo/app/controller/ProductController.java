package com.aaron.learn.dubbo.app.controller;

import com.aaron.learn.dubbo.all.api.model.GoodDTO;
import com.aaron.learn.dubbo.all.api.service.ProductRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:55 2019/9/28
 * @Modiflid By:
 */
@RestController
@RequestMapping("app/product")
public class ProductController {

    //事件通知不生效
//    @Reference(methods = { @Method(name = "getInfoById", onreturn = "productNotify.onreturn", onthrow = "productNotify.onthrow")})
    @Autowired
    ProductRemoteService productRemoteService;

    @PostMapping("/get/{id}")
    public GoodDTO getInfo(@PathVariable("id") Long id){
        GoodDTO goodDTO = productRemoteService.getInfoById(id);
        return goodDTO;
    }

}
