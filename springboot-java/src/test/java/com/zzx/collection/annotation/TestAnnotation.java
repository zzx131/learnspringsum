package com.zzx.collection.annotation;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Date: 2020/3/30
 * @Author: zhangzexin
 */
public class TestAnnotation {

    public void testAnnotation(Mode mode) {
        // 获取类中的字段
        Field[] declaredFields = mode.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            IsLike annotation = declaredField.getAnnotation(IsLike.class);
            if (null != annotation) {
                Boolean value = annotation.value();
                System.out.println(value);
                System.out.println(declaredField.getName());
            }
        }
    }

    @Test
    public void testMain() {
        List<Map<String, Object>> maps = AnnotationUtil.checkLikeFild(new Mode());
        System.out.println(maps.toString());
    }
}
