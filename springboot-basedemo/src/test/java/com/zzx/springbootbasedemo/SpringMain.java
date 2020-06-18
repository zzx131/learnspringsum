package com.zzx.springbootbasedemo;

import com.zzx.springbootbasedemo.bean.BeanConfig;
import com.zzx.springbootbasedemo.bean.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        MyService myService = (MyService) context.getBean("myService");
        myService.print();
    }
}
