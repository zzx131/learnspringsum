package com.zzx.collection.string;

import org.junit.Test;

public class StringTest {
    String s ;

    @Test
    public void testString(){
        int i = 5/3;
        System.out.println(i);
    }

    @Test
    public void testSubString(){
        String file = "E:/keystore/publickeyStore.jks";
        String fileName = file.substring(file.lastIndexOf("/")+1);
        System.out.println(fileName);
    }
}
