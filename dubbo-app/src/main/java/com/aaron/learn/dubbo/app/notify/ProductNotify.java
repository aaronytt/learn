package com.aaron.learn.dubbo.app.notify;

import com.aaron.learn.dubbo.all.api.model.GoodDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:48 2019/10/1
 * @Modiflid By:
 */
@Service
@Slf4j
public class ProductNotify implements Notify {

    public Map<Long, GoodDTO> ret = new HashMap<>();

    @Override
    public void onreturn(GoodDTO msg, Long param){
        ret.put(param,msg);
        log.info("result... " + msg.toString());
    }

    @Override
    public void onthrow(Throwable ex, Long param){
        log.error("ex... " + ex.toString());
    }

}
