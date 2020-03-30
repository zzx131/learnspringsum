package com.zzx.collection.cglib;

public class SqlService {
    public void executeSql1() throws InterruptedException {
        System.out.println("Sql 开始执行.....");
        Thread.sleep(1000);
        System.out.println("Sql 执行结束.....");
    }

    public void executeSql2() throws InterruptedException {
        System.out.println("2 Sql 开始执行.....");
        Thread.sleep(1000);
        System.out.println("2 Sql 执行结束.....");
    }
}
