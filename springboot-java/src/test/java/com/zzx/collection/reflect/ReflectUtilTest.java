package com.zzx.collection.reflect;

import cn.hutool.core.util.ReflectUtil;
import org.junit.Test;

import java.lang.reflect.Method;

public class ReflectUtilTest {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Test
    public void testReflectUtilTest() {
        Method setA = ReflectUtil.getMethod(ReflectUtilTest.class, "setA", Integer.class);
        System.out.println(setA.getName());
    }

    public static void main(String[] args) {
        ReflectUtilTest reflectUtilTest = new ReflectUtilTest();
        reflectUtilTest.testSecurityException();
        reflectUtilTest.testExecption();
    }

    public void testA() {
        ReflectUtilTest reflectUtilTest = new ReflectUtilTest();
        reflectUtilTest.testSecurityException();
        reflectUtilTest.testExecption();
        reflectUtilTest.testb();
    }

    public void testSecurityException() throws SecurityException {
        int i = 1 / 0;
        System.out.println("抛出异常");
    }

    public void testExecption() throws ArrayIndexOutOfBoundsException {
        int[] arr = new int[3];
        System.out.println(arr[5]);
    }

    public void testb() {
        int j = 10 / 0;
        throw new RuntimeException();
    }
}
