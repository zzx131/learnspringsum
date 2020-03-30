package com.zzx.collection.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SqlFacadeCglib implements MethodInterceptor {

    /**
     * 被代理的对象
     */
    private Object target;

    public SqlFacadeCglib(Object target) {
        this.target = target;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 开始执行时间
        Long startTime = System.currentTimeMillis();
        // //调用业务类（父类中）的方法
        Object result = methodProxy.invokeSuper(o, objects);
        // 执行结束
        Long endTime = System.currentTimeMillis();
        System.out.println(target.getClass().getName()+"执行executeSql耗时"+(endTime-startTime)+"ms");
        return result;
    }
}
