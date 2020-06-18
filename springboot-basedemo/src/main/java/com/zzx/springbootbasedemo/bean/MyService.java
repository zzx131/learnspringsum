package com.zzx.springbootbasedemo.bean;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
/**
 * 因为BaseService中构造器需要使用applicationContextUtil这个bean，所以需要加@DependsOn这个注解。
 *注解作用：1、保证applicationContextUtil总是在MyService之前实例化
 *       2、保证applicationContextUtil总是在MyService销毁之后销毁
 */
@DependsOn("applicationContextUtil")
public class MyService extends BaseService {

    public MyService() {
        super();
    }

    public void print() {
        dao.process();
    }
}