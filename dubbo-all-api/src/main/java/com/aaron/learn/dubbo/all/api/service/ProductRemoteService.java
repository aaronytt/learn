package com.aaron.learn.dubbo.all.api.service;

import com.aaron.learn.dubbo.all.api.model.GoodDTO;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:49 2019/9/28
 * @Modiflid By:
 */
public interface ProductRemoteService {
    GoodDTO getInfoById(Long goodId);
}
