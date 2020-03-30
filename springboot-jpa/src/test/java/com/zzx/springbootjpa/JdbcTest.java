package com.zzx.springbootjpa;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description:
 * @Date: 2020/3/28
 * @Author: zhangzexin
 */
public class JdbcTest {

    @Test
    public void testGetConnection() throws ClassNotFoundException, SQLException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";    //启动驱动
        String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&userSSL=false&serverTimezone=GMT%2B8";    //设置连接路径
        String username = "root";    //数据库用户名
        String password = "123456";    //数据库连接密码
        Class.forName(driverClassName); //执行驱动
        Connection con = DriverManager.getConnection(url, username, password); //获取连接
        System.out.println(con);
    }
}
