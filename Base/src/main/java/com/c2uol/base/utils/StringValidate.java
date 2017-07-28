package com.c2uol.base.utils;

/**
 * 
 * @描述: 字符效验工具
 * @作者: Lyon
 * @版本: v1.0
 * @时间: 2017年7月27日下午10:23:13
 *
 */
public class StringValidate {

    private StringValidate() {

    }

    /**
     * 
     * @描述: 字符为空
     * @参数: @param str
     * @参数: @return
     * @返回值: boolean
     * @版本: v1.0
     * @时间: 2017年7月27日下午10:25:11
     *
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @描述: 字符为数字
     * @参数: @param str
     * @参数: @return
     * @返回值: boolean
     * @版本: v1.0
     * @时间: 2017年7月27日下午10:25:17
     *
     */
    public static boolean isInteger(String str) {
        if (isEmpty(str)) {
            return false;
        }
        if (!str.matches("\\d+")) {
            return false;
        }
        return true;
    }
}
