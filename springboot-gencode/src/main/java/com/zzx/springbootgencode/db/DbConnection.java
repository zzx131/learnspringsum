package com.zzx.springbootgencode.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    /**
     * 获取数据库的连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        YamlDbProperties yamlDbProperties = YamlDbProperties.getValue();
        try {
           connection= DriverManager.getConnection(yamlDbProperties.getUrl(),yamlDbProperties.getUsername(),yamlDbProperties.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接
     * @param connection
     */
    public static void CloseConn(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
