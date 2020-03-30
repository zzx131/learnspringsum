package com.zzx.springbootjpa.dao;

import com.zzx.springbootjpa.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends JpaRepository<SysUser,Long> {
}
