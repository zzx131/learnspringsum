package com.zzx.springbootjpa.service.imp;

import com.zzx.springbootjpa.dao.SysUserDao;
import com.zzx.springbootjpa.model.SysUser;
import com.zzx.springbootjpa.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserServiceImp implements SysUserService {
    @Autowired
    public SysUserDao sysUserDao;

    @Override
    public List<SysUser> findAllUser() {
        return sysUserDao.findAll();
    }

    @Override
    @Transactional
    public void saveUser(SysUser sysUser) {
        sysUserDao.save(sysUser);
        int j = 12 / 0;
    }
}
