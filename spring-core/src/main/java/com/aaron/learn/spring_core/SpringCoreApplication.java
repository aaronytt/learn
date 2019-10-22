package com.aaron.learn.spring_core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:40 2019/10/8
 * @Modiflid By:
 */
@SpringBootApplication
@MapperScan("com.aaron.learn.spring_core.dao.mapper")
//@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreApplication.class);
    }

}
