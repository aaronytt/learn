package com.aaron.learn.spring_core.test.aop.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:47 2019/10/8
 * @Modiflid By:
 */
public class DynamicProxyDemo implements DynamicProxyDemoInterface {

    public String get(String name){
        return name + new Random().nextInt(100);
    }

    public static void main(String[] args) {
        ProxyOfInstance proxyOfInstance = new ProxyOfInstance();

        Object obj = proxyOfInstance.newProxyInstance(new DynamicProxyDemo());
//        System.out.println(obj);
//        System.out.println(((DynamicProxyDemoInterface)obj));
        System.out.println(((DynamicProxyDemoInterface)obj).get("get"));
    }
}

interface DynamicProxyDemoInterface{
    String get(String name);
}

class ProxyOfInstance implements InvocationHandler{

    // 目标对象
    private Object targetObject;
    //绑定关系，也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法。
    public Object newProxyInstance(Object targetObject){
        this.targetObject=targetObject;
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
        //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        //根据传入的目标返回一个代理对象
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start-->>");
        Object ret=null;
        try{
            /*原对象方法调用前处理日志信息*/
            System.out.println("satrt-->>");

            //调用目标方法
            ret=method.invoke(targetObject, args);
            /*原对象方法调用后处理日志信息*/
            System.out.println("success-->>");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error-->>");
            throw e;
        }
        return ret;
    }

}
