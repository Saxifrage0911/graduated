package com.xietian.graduated.common.util;

import org.springframework.util.DigestUtils;

public class Md5Encrypt {

    public static String getMd5Password(String password, String salt) {
        // 拼接原密码与盐值
        String str = salt + password + salt;
        // 循环加密5次
        for (int i = 0; i < 5; i++) {
            // DigestUtils：springboot提供的工具类
            str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
        }
        // 返回结果
        return str;
    }
}
