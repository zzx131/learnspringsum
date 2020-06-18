package com.zzx.collection.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 注解的工具类
 * @Date: 2020/3/31
 * @Author: zhangzexin
 */
public class AnnotationUtil {

    /**
     * @param model:
     * @description: 检查注解isLike
     * @author: zhangzexin
     * @date: 2020/3/31  21:51
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     **/
    public static <T> List<Map<String, Object>> checkLikeFild(T model) {
        List<Map<String, Object>> result = new ArrayList<>();

        Field[] declaredFields = model.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            IsLike annotation = declaredField.getAnnotation(IsLike.class);
            if (null != annotation) {
                Map<String, Object> oneData = new HashMap<>();
                oneData.put("fildName", declaredField.getName());
                oneData.put("value", annotation.value());

                result.add(oneData);
            }
        }
        return result;
    }
}
