package com.zzx.collection.java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    /**
     * 排序
     */
    @Test
    public void testSort() {
        List<Integer> lists = Lists.newArrayList(3, 5, 1, 2, 6);
        lists.sort(((o1, o2) -> {
            if (o1 - o2 > 0) {
                return 1;
            } else if (o1 == o2) {
                return 0;
            } else {
                return -1;
            }
        }));
        System.out.println(lists);
    }

    /**
     * java8 排序中的Strean流
     */
    @Test
    public void testStreamSort() {
        List<Integer> lists = Lists.newArrayList(3, 5, 1, 2, 6);
        /*List<Integer> collect = lists.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
        collect.sort(Comparator.reverseOrder());
        System.out.println(collect);*/

        List<Integer> collect = lists.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    /**
     * java 过滤
     */
    @Test
    public void testFilter() {
        List<Integer> lists = Lists.newArrayList(3, 5, 1, 2, 6);
        List<Integer> collect = lists.stream().filter(one -> one > 3).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * java 分组
     */
    @Test
    public void testGroupByCollect() {
        List<Integer> lists = Lists.newArrayList(3, 5, 1, 2, 6);
        Map<Object, List<Integer>> collect = lists.stream().collect(Collectors.groupingBy((Function<Integer, Object>) integer -> integer > 2));
        System.out.println(collect);

        List<User> users = Lists.newArrayList(new User("1", "张三", 10),
                new User("2", "李四", 20),
                new User("3", "王五", 50),
                new User("4", "赵六", 20),
                new User("5", "赵六", 20)
        );
        // Map<Object, List<User>> groupUser = users.stream().collect(Collectors.groupingBy((Function<User, Object>) user -> user.getId()));

        Map<Object, List<User>> groupUser = users.stream().collect(Collectors.groupingBy((Function<User, Object>) user -> user.getuName() + user.getAge()));
        System.out.println(groupUser);
    }

    /**
     * 拼接字符串
     */
    @Test
    public void testJoin() {
        List<String> lists = Lists.newArrayList("3", "5", "1", "2", "6");
        String result = lists.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }
}
