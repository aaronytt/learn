package com.aaron.learn.spring_core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:54 2019/7/23
 * @Modiflid By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {

    private String name;
    private int age;

}
