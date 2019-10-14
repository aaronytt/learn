package com.aaron.learn.dubbo.app.notify;

import com.aaron.learn.dubbo.all.api.model.GoodDTO;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:04 2019/10/1
 * @Modiflid By:
 */
public interface Notify {

    public void onreturn(GoodDTO msg, Long param);
    public void onthrow(Throwable ex, Long param);

}
