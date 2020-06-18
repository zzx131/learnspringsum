package com.zzx.collection.invoice.role;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RoleMapperProxy implements InvocationHandler {

    private Object target;

    // 目标对象
  /*  private Class<?> target;

    public RoleMapperProxy(Class<?> target) {
        this.target = target;
    }*/

    public RoleMapperProxy(Object object) {
        this.target = object;
    }

   /* @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类执行前");
        Object result = method.invoke(this, args);
        System.out.println("代理方法执行后");
        return result;
    }*/

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类执行前");
        Object result = method.invoke(target, args);
        System.out.println("代理方法执行后");
        return result;
    }

    // 生成代理类--接口的代理类
   /* public Object CreatProxyedObjInter() {
        // return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return Proxy.newProxyInstance(target.getClassLoader(), new Class[] { target },this);
    }*/

    public Object CreatProxyedObjImp() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
