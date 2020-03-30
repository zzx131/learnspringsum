package com.zzx.shiro;

import com.zzx.shiro.service.LoginService;
import com.zzx.shiro.shiro.filter.CustomFormAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        ConfigurableApplicationContext context = springApplication.run(args);
    }

}
