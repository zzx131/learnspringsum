package com.zzx.collection.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserMapperCglib implements MethodInterceptor {

    /**
     * 被代理的对象
     */
    private Object target;

    public UserMapperCglib(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用方法前。。。");
        // //调用业务类（父类中）的方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用方法后。。。");
        return result;
    }
}
