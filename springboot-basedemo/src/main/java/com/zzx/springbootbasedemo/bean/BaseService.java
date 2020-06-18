package com.zzx.springbootbasedemo.bean;


public abstract class BaseService {
    Dao dao;

    public BaseService() {
        this.dao = (Dao) ApplicationContextUtil.getObject("dao");
    }
}
