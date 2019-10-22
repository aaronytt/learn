package com.aaron.learn.spring_core.test.confition;

import com.aaron.learn.spring_core.test.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:31 2019/10/8
 * @Modiflid By:
 */
@Configuration
public class ConfitionTest {

    @Bean
    @Conditional(WindowsCondition.class)
    public Person li(){
        System.out.println("给容器初始化bean-li...");
        return Person.builder().name("li").age(15).build();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public Person wang(){
        System.out.println("给容器初始化bean-wang...");
        return Person.builder().name("wang").age(16).build();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfitionTest.class);
        Environment environment = applicationContext.getEnvironment();

        String ev = environment.getProperty("os.name");
        System.out.println(ev);
        Person person1 = (Person) applicationContext.getBean("li");
        Person person2 = (Person) applicationContext.getBean("wang");//null
    }

}
