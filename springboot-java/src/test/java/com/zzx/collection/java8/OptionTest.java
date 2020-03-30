package com.zzx.collection.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionTest {
    /**
     * Optional 类进行
     */
    @Test
    public void testOptionTest(){
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
}
