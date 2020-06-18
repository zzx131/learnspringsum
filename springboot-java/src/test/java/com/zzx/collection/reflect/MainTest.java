package com.zzx.collection.reflect;

import com.zzx.collection.reflect.domain.TestReflect;
import org.junit.Test;

import java.lang.reflect.Field;

public class MainTest {

    @Test
    public void testReflect() throws NoSuchFieldException {
        Field[] declaredFields = TestReflect.class.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            String name = field.getName();
            System.out.println(name);
        }
    }

    @Test
    public void testBool() {
        TestReflect reflect = new TestReflect();
        System.out.println(reflect.getFlag());
    }
}
