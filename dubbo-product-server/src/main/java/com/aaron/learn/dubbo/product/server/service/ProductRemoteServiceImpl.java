package com.aaron.learn.dubbo.product.server.service;

import com.aaron.learn.dubbo.all.api.model.GoodDTO;
import com.aaron.learn.dubbo.product.server.dao.mapper.GoodMapper;
import com.aaron.learn.dubbo.product.server.dao.po.Good;
import com.aaron.learn.dubbo.all.api.service.ProductRemoteService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:49 2019/9/28
 * @Modiflid By:
 */
@Service(interfaceClass = ProductRemoteService.class)
@Component
public class ProductRemoteServiceImpl implements ProductRemoteService{

    @Autowired
    GoodMapper goodMapper;

    @Override
    public GoodDTO getInfoById(Long goodId){

        if(goodId>5){
            int i = 1/0;
        }

        Good good = goodMapper.selectByPrimaryKey(goodId);
        return good.toDTO();
    }


}
