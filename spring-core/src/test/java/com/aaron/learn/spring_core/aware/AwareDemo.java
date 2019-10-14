package com.aaron.learn.spring_core.aware;

import com.aaron.learn.spring_core.applicationcontext.ApplicationContextParser;
import com.aaron.learn.spring_core.model.Apple;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:16 2019/10/8
 * @Modiflid By:
 */
//Aware自定义组件想要使用Spring容器底层的组件(ApplicationContext, BeanFactory, ......)
//    思路: 自定义组件实现xxxAware, 在创建对象的时候, 会调用接口规定的方法注入到相关组件:Aware
@Configuration
public class AwareDemo implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    //把Spring底层的组件可以注入到自定义的bean中,ApplicationContextAware是利用ApplicationContextAwareProcessor来处理的, 其它XXXAware也类似, 都有相关的Processor来处理, 其实就是后置处理器来处理;
    //XXXAware---->功能使用了XXXProcessor来处理的, 这就是后置处理器的作用;
    //   ApplicaitonContextAware--->ApplicationContextProcessor后置处理器来处理的
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Apple apple(){
        return new Apple();
    }

    public static void main(String[] args) {
        //注解方式获取IOC容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextParser.class);
        Apple apple = (Apple) applicationContext.getBean("apple");
        System.out.println(apple);
    }
}
