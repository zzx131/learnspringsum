package com.zhangzx.mybatisplus.license.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zhangzx.mybatisplus.license.model.SysLic;
import com.zhangzx.mybatisplus.license.service.SysLicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/3/12
 * @Author: zhangzexin
 */
@RestController
@RequestMapping("/sysLic")
public class SysLicController {
    @Autowired
    private SysLicService sysLicService;

    /**
     * @param sysLic:
     * @description: 保存证书
     * @author: zhangzexin
     * @date: 2020/3/12  10:29
     * @return: boolean
     **/
    @PostMapping("/save")
    public boolean save(@RequestBody SysLic sysLic) {
        boolean saveFlag = sysLicService.save(sysLic);
        return saveFlag;
    }

    /**
     * @description: 查看所有证书
     * @author: zhangzexin
     * @date: 2020/3/12  10:32
     * @return: java.util.List<com.zhangzx.mybatisplus.license.model.SysLic>
     **/
    @GetMapping("/listAll")
    public List<SysLic> listAll() {
        List<SysLic> list = sysLicService.list();
        return list;
    }

    /***
     * @description: 传参查看证书
     * @author: zhangzexin
     * @date: 2020/3/12  10:34
     * @param sysLic: 传入不同的参数进行查询
     * @return: java.util.List<com.zhangzx.mybatisplus.license.model.SysLic>
     **/
    @PostMapping("/listByParams")
    public List<SysLic> listByParams(@RequestBody SysLic sysLic) {
        QueryWrapper<SysLic> wrapper = new QueryWrapper<>();
        wrapper.setEntity(sysLic);
        List<SysLic> list = sysLicService.list(wrapper);
        return list;
    }

    /**
     * @param sysLic:
     * @description: 删除
     * @author: zhangzexin
     * @date: 2020/3/12  11:32
     * @return: void
     **/
    @DeleteMapping("/del")
    public Boolean del(@RequestBody SysLic sysLic) {
        // 如果没有加删除标识将在这里加上
        if (StringUtils.isEmpty(sysLic.getIsDeleted())) {
            sysLic.setIsDeleted(true);
        }
        UpdateWrapper<SysLic> wrapper = new UpdateWrapper<>();
        wrapper.setEntity(sysLic);
        boolean updateResult = sysLicService.update(wrapper);
        return updateResult;
    }

    /**
     * @param id:
     * @description: 按照id进行删除
     * @author: zhangzexin
     * @date: 2020/3/12  11:39
     * @return: java.lang.Boolean
     **/
    @DeleteMapping("/delById")
    public Boolean delById(int id) {
        SysLic sysLic = new SysLic();
        sysLic.setId(id);
        sysLic.setIsDeleted(true);
        boolean updateResult = sysLicService.updateById(sysLic);
        return updateResult;
    }

    /**
     * @param ids:
     * @description: 通过id删除全部
     * @author: zhangzexin
     * @date: 2020/3/12  11:45
     * @return: java.lang.Boolean
     **/
    @DeleteMapping("/delByIds")
    public Boolean delByIds(@RequestBody List<Integer> ids) {
        List<SysLic> sysLics = new ArrayList<>();
        ids.forEach(one -> {
            SysLic sysLic = new SysLic();
            sysLic.setId(one);
            sysLic.setIsDeleted(true);

            sysLics.add(sysLic);
        });
        boolean resultFlag = sysLicService.updateBatchById(sysLics);
        return resultFlag;
    }

    /**
     * 修改证书
     *
     * @param sysLic
     * @return
     */
    @PostMapping("/update")
    public Boolean update(@RequestBody SysLic sysLic) {
        UpdateWrapper<SysLic> wrapper = new UpdateWrapper<>();
        wrapper.setEntity(sysLic);
        boolean updateResult = sysLicService.update(wrapper);
        return updateResult;
    }


}
