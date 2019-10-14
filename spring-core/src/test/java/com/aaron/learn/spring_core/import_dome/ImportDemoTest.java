package com.aaron.learn.spring_core.import_dome;

import com.aaron.learn.spring_core.import_dome.factory.MyFactoryBean;
import com.aaron.learn.spring_core.import_dome.registrar.MyImportBeanDefinitionRegistrar;
import com.aaron.learn.spring_core.import_dome.selector.MyImportSelector;
import com.aaron.learn.spring_core.model.Dog;
import com.aaron.learn.spring_core.model.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

/**
 * @Author: aaron
 * @Descriotion:
 * 笔记：
 *  给容器注册组件的方式
 *  1. @Bean {@link Bean} ： [导入第三方的类或包的组件]，比如Person的第三方的类，需要在我们的IOC容器中使用
 *  2. 包扫描注解 + 组件的标注注解（@ComponentScan: @Controller, @Service ...）
 *  3. @Import {@link Import}:[快速给IOC容器导入一个组件]
 *      a. @Import(需要导入的组件)：容器会自动注册这个组件，bean的id为全名
 *      b. ImportSelector {@link ImportSelector}: 一个接口，返回需要导入到容器的组建的全类名
 *      c. ImportBeanDefinitionRegistrar {@link ImportBeanDefinitionRegistrar}:
 *          可以手动添加组件到IOC容器， 所有Bean的注册可以使用BeanDefinitionRegistrar
 *  4. 使用Spring提供的{@link FactoryBean}(工厂bean)
 *
 *
 * @Date: 14:47 2019/7/23
 * @Modiflid By:
 */
@Configuration
@Import(value = {Dog.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class, MyFactoryBean.class})
public class ImportDemoTest {

    @Bean
    public Person liu(){
        System.out.println("给容器初始化bean-liu...");
        return Person.builder().name("liu").age(12).build();
    }

}
