package com.aaron.learn.spring_core.lazy_demo;

import com.aaron.learn.spring_core.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:18 2019/10/8
 * @Modiflid By:
 */
@Configuration
public class LazyDemo {
    /**
     * 给容器注入一个bean默认是单实例的
     * 懒加载：由于容器启动默认创建bean,主要单主要针对实例bean,仅当第一次使用单实例bean时才创建被初始化
     */
    @Lazy
    @Bean
    public Person person(){
        System.out.println("Lazy...Person...");
        return new Person();
    }
}
