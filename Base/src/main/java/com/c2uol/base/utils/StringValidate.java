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

	public static boolean isEmpty(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

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
