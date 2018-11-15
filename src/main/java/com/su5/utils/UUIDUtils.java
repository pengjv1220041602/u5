package com.su5.utils;

import java.util.UUID;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001516:01
 * @Version 1.0
 * @Description:
 */
public class UUIDUtils {
    public static String getUUID () {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
