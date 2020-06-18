package com.zzx.springbootbasedemo;


import org.apache.tomcat.util.codec.binary.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class CipherTester_v1 {
    private static final String default_key = "lianghuilonglong";    //注意：密钥长度;    //私钥   AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes。
    private static final String default_iv = "aabbccddeeffgghh";    //初始化向量参数，AES 为16bytes. DES 为8bytes.

    //=== Test Entry ===
    public static void main(String[] args) throws Exception {
        CipherTester_v1 test = new CipherTester_v1();
        test.encrypt();
        test.decrypt();
    }


    //加密方式： AES128(CBC/PKCS5Padding) + Base64, 私钥：lianghuilonglong,要加密的字符串abcdefg
    public String encrypt() throws Exception {
        String text = "abcdefg";       //要加密的字符串

        Key keySpec = new SecretKeySpec(default_key.getBytes(), "AES");    //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
        IvParameterSpec ivSpec = new IvParameterSpec(default_iv.getBytes());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");    //实例化加密类，参数为加密方式，要写全
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec); //初始化，此方法可以采用三种方式，按服务器要求来添加。（1）无第三个参数（2）第三个参数为SecureRandom random = new SecureRandom();中random对象，随机数。(AES不可采用这种方法)（3）采用此代码中的IVParameterSpec

        //cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        //SecureRandom random = new SecureRandom();
        //cipher.init(Cipher.ENCRYPT_MODE, keySpec, random);

        byte[] b = cipher.doFinal(text.getBytes());        //加密操作,返回加密后的字节数组，然后需要编码。主要编解码方式有Base64, HEX, UUE, 7bit等等。此处看服务器需要什么编码方式
        String encryptText = Base64.encodeBase64String(b);     //Base64、HEX等编解码
        System.out.println("encryptText=" + encryptText);
        return encryptText;
    }

    //加密方式： AES128(CBC/PKCS5Padding) + Base64, 私钥：lianghuilonglong
    public String decrypt() throws Exception {
        String keySpec = default_key;
        String textDeCipher = "9ID92FHK0cW6O+Wd4Snz+g==";   //从服务器返回的加密字符串，需要解密的字符串
        byte[] byteArray = Base64.decodeBase64(textDeCipher);   //先用Base64解码    　

        IvParameterSpec ivSpec = new IvParameterSpec(default_iv.getBytes());
        Key key = new SecretKeySpec(keySpec.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);     //与加密时不同MODE:Cipher.DECRYPT_MODE
        byte[] ret = cipher.doFinal(byteArray);
        String rawText = new String(ret, "utf-8");
        System.out.println("rawText=" + rawText);
        return rawText;
    }


}
