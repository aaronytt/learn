package com.aaron.learn.spring_core.import_dome.factory;

import com.aaron.learn.spring_core.model.Apple;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 16:53 2019/7/23
 * @Modiflid By:
 */
public class MyFactoryBean implements FactoryBean<Apple> {

    @Override
    public Apple getObject() throws Exception {
        return new Apple();
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
