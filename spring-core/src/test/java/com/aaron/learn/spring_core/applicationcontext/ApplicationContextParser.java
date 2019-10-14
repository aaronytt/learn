package com.aaron.learn.spring_core.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:01 2019/10/8
 * @Modiflid By:
 */
//配置类 == 配置文件(ApplicationContextParser.xml)
@Configuration
public class ApplicationContextParser {

    //xml方式获取IOC容器
    ApplicationContext applicationContext_class = new ClassPathXmlApplicationContext("ApplicationContextParser.xml");
    //注解方式获取IOC容器
    ApplicationContext applicationContext_annotation = new AnnotationConfigApplicationContext("com.aaron.learn.spring_core");

    //给容器注册一个bean, 返回类型为bean的类型
    @Bean("name_class")
    public String name(){
        return "name";
    }

}
