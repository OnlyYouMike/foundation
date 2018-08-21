package com.aifenxiang.foundation.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: zj
 * @create: 2018-08-21 23:49
 **/
public class Md5Util {

    /**
     * 获取字符串的MD5值
     * @param s 待计算字符串
     * @param encoding 字符串编码
     * @return MD5值
     */
    public static String getMd5(String s, String encoding) {
        byte abyte0[];
        MessageDigest messagedigest;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nosuchalgorithmexception) {
            throw new IllegalArgumentException("no md5 support");
        }
        try {
            messagedigest.update(s.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        abyte0 = messagedigest.digest();
        return byte2hex(abyte0);

    }

    /**
     * 获取字节数组的MD5值
     * @param bytes 字节数组
     * @return MD5值
     */
    public static String getMd5(byte[] bytes) {
        byte abyte0[];
        MessageDigest messagedigest;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nosuchalgorithmexception) {
            throw new IllegalArgumentException("no md5 support");
        }
        messagedigest.update(bytes);
        abyte0 = messagedigest.digest();
        return byte2hex(abyte0);

    }

    /**
     * 转换直接数组为16进制字符串
     * @param bytes 字节数组
     * @return 16进制字符串
     */
    public static String byte2hex(byte bytes[]) {
        StringBuffer stringBuffer = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString((long) bytes[i] & (long) 255, 16));
        }

        return stringBuffer.toString().toUpperCase();
    }

}
