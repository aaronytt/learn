package com.aaron.learn.spring_core.test.model;

import lombok.Data;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:55 2019/7/25
 * @Modiflid By:
 */
@Data
public class Bird {

    public Bird() {
        super();
    }

//    @Value("sam")
    private String name;
//    @Value("#{20-2}")
    private Integer age;
//    @Value("${color}")
    private String color;

    public String drive(String name){
        this.name = name;
        System.out.println("car: " + this.name.toString() +" drive.....");
        return "OK";
    }

}
