package com.zavr.zavrcommonservice.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class Md5Util {
    public static String EncoderByMd5(String str) throws Exception{
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    public static boolean CheckPassword(String newpasswd,String oldpasswd) throws Exception{
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        try{
            System.out.println(EncoderByMd5("123456"));//4QrcOUm6Wau+VuBX8g+IPg==
            System.out.println(CheckPassword("123456","4QrcOUm6Wau+VuBX8g+IPg=="));
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
