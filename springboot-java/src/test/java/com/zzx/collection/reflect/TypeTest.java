package com.zzx.collection.reflect;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class TypeTest {
    public void testType(TypeTest p0,
                         List<TypeTest> p1,
                         Map<String, TypeTest> p2,
                         List<String>[] p3,
                         Map<String, TypeTest>[] p4,
                         List<? extends TypeTest> p5,
                         Map<? extends TypeTest, ? super TypeTest> p6) {
    }

    @Test
    public void testTypeMain() {
        Method[] methods = TypeTest.class.getMethods();
        for (Method method : methods) {
            if ("testType".equals(method.getName())) {
                Type[] parameterTypes = method.getGenericParameterTypes();

                // 第一个参数Class TypeTest
                Class type0 = (Class) parameterTypes[0];
                System.out.println(type0.getName());

                // 第二个参数 List<TypeTest> ParameterizedType
                ParameterizedType parameterizedType1 = (ParameterizedType) parameterTypes[1];
                Type[] actualTypeArguments = parameterizedType1.getActualTypeArguments();
                Class type1 = (Class) actualTypeArguments[0];
                System.out.println(type1.getName());

                // 第三个参数  Map<String,TypeTest>
                ParameterizedType parameterizedType2 = (ParameterizedType) parameterTypes[2];
                Type[] actualTypeArguments1 = parameterizedType2.getActualTypeArguments();
                Class type2_1 = (Class) actualTypeArguments1[0];
                Class type2_2 = (Class) actualTypeArguments1[1];
                System.out.println("type2_1:" + type2_1.getName() + ",type2_2:" + type2_2.getName());

                // 第四个参数 List<String>[] GenericArrayType

            }
        }
    }
}
