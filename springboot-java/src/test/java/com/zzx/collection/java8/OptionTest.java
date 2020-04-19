package com.zzx.collection.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionTest {
    /**
     * Optional 类进行
     */
    @Test
    public void testOptionTest() {
        User user = new User();
        user.setId("1");
        user.setuName("张三");
        /*List<Role> roles = new ArrayList<>();

        roles.add(new Role("1","管理员"));
        roles.add(new Role("2","管理员A"));
        roles.add(new Role("3","管理员B"));

        user.setRoles(roles);*/

        // 用Optional来包装类
        Optional<User> userOptional = Optional.ofNullable(user);
        // List<Role> getRole = userOptional.map(User::getRoles).orElse(Collections.emptyList());
        List<Role> getRole = userOptional.map(one -> one.getRoles()).orElse(Collections.emptyList());
        System.out.println(getRole.toString());
    }

    @Test
    public void testFilter() {
        User user = new User();
        user.setId("1");
        user.setuName("张三");

        List<User> users = new ArrayList<>();
        users.add(user);

        List<User> collect = users.stream().filter(user1 -> user1.getId().equals("2")).collect(Collectors.toList());
        System.out.println(collect.size());

    }

    @Test
    public void testF() {
        List<Integer> strings = new ArrayList<>();
        strings.add(3);

        List<Integer> collect = strings.stream().filter(s -> 5 == s).collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void testG() {
        String PW_PATTERN = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";


        //符合要求密码
        String pw16 = "tips@A123456";
        System.out.println(pw16.matches(PW_PATTERN));
    }

}
