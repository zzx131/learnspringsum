package com.zzx.collection.invoice;

import com.zzx.collection.invoice.hello.Hello;
import com.zzx.collection.invoice.hello.HelloInterface;
import com.zzx.collection.invoice.hello.ProxyHandler;
import com.zzx.collection.invoice.role.RoleMapper;
import com.zzx.collection.invoice.role.RoleMapperImp;
import com.zzx.collection.invoice.role.RoleMapperProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class InvokeTest {
   /* @Test
    public void testInvoke(){
        RoleMapperProxy roleMapperProxy = new RoleMapperProxy(RoleMapper.class);
        Object o = roleMapperProxy.CreatProxyedObjInter();
        System.out.println(o);
    }*/

    @Test
    public void testInvokeImp() {
        RoleMapper roleMapper = new RoleMapperImp();
        RoleMapperProxy roleMapperProxy = new RoleMapperProxy(roleMapper);
        // RoleMapper o = (RoleMapper)Proxy.newProxyInstance(roleMapper.getClass().getClassLoader(), roleMapper.getClass().getInterfaces(), roleMapperProxy);
        RoleMapper o = (RoleMapper) roleMapperProxy.CreatProxyedObjImp();
        o.getRoles();
    }

    @Test
    public void testHello() {
        // System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloInterface hello = new Hello();
        InvocationHandler handler = new ProxyHandler(hello);
        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        proxyHello.sayHello();
    }
}
