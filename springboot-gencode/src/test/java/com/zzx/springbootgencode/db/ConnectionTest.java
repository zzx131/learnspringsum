package com.zzx.springbootgencode.db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionTest {
    @Test
    public void getConnect(){
        Connection connection = DbConnection.getConnection();
        System.out.println(connection);
    }
}
