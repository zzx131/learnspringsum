package com.zzx.springbootjpa.service;

import com.zzx.springbootjpa.model.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void testSave(){
        SysUser sysUser = new SysUser();
        sysUser.setName("李四");
        sysUser.setBrithday(new Date());
        sysUser.setAge(11);
        sysUserService.saveUser(sysUser);
    }

    @Test
    public void testFindAll(){
        List<SysUser> allUser = sysUserService.findAllUser();
        allUser.forEach(one-> System.out.println(one.toString()));
    }
}
