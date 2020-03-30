package com.zzx.springbootjpa.service;


import com.zzx.springbootjpa.model.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> findAllUser();

    void saveUser(SysUser sysUser);
}
