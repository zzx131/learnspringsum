package com.zzx.collection.map;

import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class MapTest {
    @Test
    public void testMap() {
        HashMap map = new HashMap();
        map.put(1, "zzx");
        map.put(2, "lishi");
        map.put(3, "wangwu");

        Set set = map.entrySet();
        Set key = map.keySet();
        Collection values = map.values();

        map.forEach((o, o2) -> System.out.println(o));

        // 计算
        map.compute(1, new BiFunction() {
            @Override
            public Object apply(Object o, Object o2) {
                return null;
            }
        });
    }
}
