package com.zzx.collection.exception;

import org.junit.Test;

import java.io.IOException;

public class MyExceptionTest {
    /**
     * io异常
     *
     * @throws IOException
     */
    public void testThrowIoException() throws IOException {
        System.out.println("hello testThrowIoException");
        throw new IOException();
    }

    /**
     * 运行时异常
     */
    public void testThrowRunTimeException() {
        System.out.println("testThrow");
        throw new RuntimeException();
    }

    public void testMyException() throws MyException {
        throw new MyException();
    }

    @Test
    public void mainTest() throws IOException {
        MyExceptionTest myExceptionTest = new MyExceptionTest();
        // 可以捕捉 runTimeException异常，但是并不需要 throws
        try {
            myExceptionTest.testThrowRunTimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        // ioException 异常处理
        myExceptionTest.testThrowIoException();
        // 这段语句不能够执行
        System.out.println("end");
    }


}
