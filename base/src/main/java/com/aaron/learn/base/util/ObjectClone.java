package com.aaron.learn.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:21 2019/10/1
 * @Modiflid By:
 */
public class ObjectClone {

    /**
     * 根据提供的参数拷贝一个数据一致的对象
     * @param source
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, Class<T> clz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取指定对象的Class对象
//      Class<T> clz = T;//Student.class
        /* 为什么要多加一个参数Class<T> clz?
         * 是因为泛型, 为了返回值直接是该对象, 而不是Object.
         */
        T newObj = null;
        //根据class对象创建当前类型的实例(空对象)
        newObj = clz.newInstance();

        setValue(source,newObj,clz);

        return newObj;
    }

    private static  <K,T extends K> void setValue(Object source, T newObj, Class<K> clz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if(null == clz){
            return;
        }
        //获取当前类中包含的所有属性
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            //拼接获取getter方法的名称
            String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            //根据方法名称获取方法对象
            Method method_get = null;//getter方法
            try {
                method_get = source.getClass().getMethod(getMethodName);
            } catch (Exception e) {
                continue;
            }
            //执行源对象指定属性的getter方法，获取属性值
            Object returnval = method_get.invoke(source);

            //拼接获取setter方法的名称
            String setMethodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            //根据方法名称获取方法对象
            Method method_set = clz.getMethod(setMethodName, field.getType());//setter方法
            //执行新对象的setter方法，将源对象的属性值设置给新对象
            method_set.invoke(newObj, returnval);
        }

        setValue(source, newObj , clz.getSuperclass());

    }

}