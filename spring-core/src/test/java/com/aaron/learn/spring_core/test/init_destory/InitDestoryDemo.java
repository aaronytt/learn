package com.aaron.learn.spring_core.test.init_destory;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 1:42 2019/10/18
 * @Modiflid By:
 */
@Data
@Builder
public class InitDestoryDemo implements InitializingBean, DisposableBean {

    public InitDestoryDemo() {
        System.out.println("Constructor...");
    }

    /**
     * 按以下书写顺序执行初始化和销毁
     */
    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }

    public void init(){
        System.out.println("init...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy...");
    }

    public void beanDestory(){
        System.out.println("bean.destory...");
    }

    public void demo(){
        System.out.println("InitDestoryDemo run...");
    }

}
