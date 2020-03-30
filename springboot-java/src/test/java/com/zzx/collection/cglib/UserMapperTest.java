package com.zzx.collection.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Method;

public class UserMapperTest {

    public static void main(String[] args) throws NoSuchMethodException {
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\java");
        UserMapperCglib userMapperCglib = new UserMapperCglib(UserMapper.class);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserMapper.class);
        enhancer.setCallback(userMapperCglib);

        UserMapper userMapper = (UserMapper) enhancer.create();
        Method getUsers = userMapper.getClass().getMethod("getUsers", null);
        System.out.println(getUsers);

        userMapper.getUsers();
    }
}
