package com.aaron.learn.base;

import java.util.Date;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 9:20 2019/10/11
 * @Modiflid By:
 */
public class SuperTest extends Date {

    public static void main(String[] args) {
        new SuperTest().test();
    }

    public void test(){
        System.out.println(super.getClass().getName());
    }

}

