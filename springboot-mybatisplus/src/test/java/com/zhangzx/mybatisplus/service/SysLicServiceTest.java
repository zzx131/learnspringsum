package com.zhangzx.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhangzx.mybatisplus.license.model.SysLic;
import com.zhangzx.mybatisplus.license.service.SysLicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/3/12
 * @Author: zhangzexin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLicServiceTest {

    @Autowired
    private SysLicService sysLicService;

    /**
     * @description: 测试查询全部
     * @author: zhangzexin
     * @date: 2020/3/12  11:09
     * @return: void
     **/
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysLic> list = sysLicService.list();
        System.out.println(list.toString());
    }

    /**
     * @description: 测试按照实体进行查询
     * @author: zhangzexin
     * @date: 2020/3/12  13:23
     * @return: void
     **/
    @Test
    public void testByEntity() {
        SysLic sysLic = new SysLic();
        sysLic.setId(1);
        QueryWrapper<SysLic> wrapper = new QueryWrapper<>();
        wrapper.setEntity(sysLic);
        List<SysLic> list = sysLicService.list(wrapper);
        System.out.println(list.toString());
    }

    /**
     * 测试保存
     */
    @Test
    public void testSave() {
        SysLic sysLic = new SysLic();
        sysLic.setPublicStorePwd("1234");
        sysLic.setPrivateStorePwd("5678");
        sysLic.setIssuedTime(new Timestamp(System.currentTimeMillis()));
        sysLic.setExpiryTime(new Timestamp(System.currentTimeMillis() + 1000));
        sysLic.setConsumerType("user");
        sysLic.setProductCode("1");
        sysLic.setModelCode("123");
        sysLic.setAuthNumber(1);
        sysLic.setAuthorizer("zhangsan");
        sysLic.setUserdCompany("tips");
        sysLic.setUserdHardware("hhhhh");
        sysLic.setCreateTime(LocalDateTime.now());
        sysLic.setModifiedTime(LocalDateTime.now());
        sysLic.setIsDeleted(false);
        sysLicService.save(sysLic);

        List<SysLic> list = sysLicService.list();
        System.out.println(list.size());
    }

    public void testUpdate() {

    }


}
