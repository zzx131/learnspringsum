package com.zzx.collection.list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListTest {
    @Test
    public void testArrayList(){
        // 创建集合
        List<String> list = new ArrayList<String>();
        List<String> strings = Lists.newArrayList("张三","李四","王五");
        // 输出集合元素
        /*for (String one:strings){
            System.out.println(one);
        }*/
       /* strings.forEach(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
       /* strings.forEach(one->{
            System.out.println(one);
        });*/

       // strings.forEach(one-> System.out.println(one));

       // 删除集合元素
        /*strings.forEach(one->{
            if ("李四".equals(one)){
                strings.remove(one);
            }
        });*/
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if ("张三".equals(next)){
                iterator.remove();
            }
        }
        strings.forEach(System.out::println);
    }

    @Test
    public void testArrayListCept(){
        List<Integer> datasource = new ArrayList<>();
        for (int i= 0;i<15;i++){
            datasource.add(i);
        }
        datasource.forEach(System.out::println);
    }
}
