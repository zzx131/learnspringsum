package com.zzx.springbootbasedemo.bean;

import org.springframework.stereotype.Component;

@Component
public class Dao {
    public void process() {
        System.out.println("抽象父类中成功注入dao");
    }
}
