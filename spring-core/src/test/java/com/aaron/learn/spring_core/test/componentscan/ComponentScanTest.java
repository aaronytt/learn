package com.aaron.learn.spring_core.test.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:41 2019/10/8
 * @Modiflid By:
 */
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[] 指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] 指定扫描的时候只需要包含哪些组件
//useDefaultFilters = false 默认是true,扫描所有组件，要改成false
//－－－－扫描规则如下
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；比如按BookService类型
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则，自已写类，实现TypeFilter接口(例如：DemoTypeFilter)

@ComponentScan(value= "com.aaron.learn.spring_core.test.componentscan",
        includeFilters={
            @ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
            @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={ComponentScanService.class}),
            @ComponentScan.Filter(type=FilterType.CUSTOM,classes={DemoTypeFilter.class})
        },
        excludeFilters = {
                @ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
                @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={ComponentScanService.class}),
                @ComponentScan.Filter(type=FilterType.CUSTOM,classes={DemoTypeFilter.class})
        },
        useDefaultFilters=false)//默认是true,扫描所有组件，要改成false,使用自定义扫描范围
@Configuration
public class ComponentScanTest {

}

