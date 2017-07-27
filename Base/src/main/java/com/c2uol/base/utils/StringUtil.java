package com.c2uol.base.utils;

public class StringUtil {

	private StringUtil() {

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
