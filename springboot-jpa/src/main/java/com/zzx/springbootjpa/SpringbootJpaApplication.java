package com.zzx.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootJpaApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication springApplication = new SpringApplication(SpringbootJpaApplication.class);
        ConfigurableApplicationContext context = springApplication.run(args);
        /*DataSource dataSource = context.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println(context.getBean(DataSource.class));
        context.close();*/
    }

}
