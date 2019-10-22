package com.aaron.learn.spring_core.test.aop;

import com.aaron.learn.spring_core.test.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarBean {
    @Bean
    public Car car(){
        System.out.println("Car Bean......");
        return new Car();
    }
}
