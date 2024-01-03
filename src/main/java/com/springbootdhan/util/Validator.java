package com.springbootdhan.util;

public class Validator {
	public static boolean isValidLong(String longStr) {
		try {
			Long.parseLong(longStr);
			return true;
		}catch (NumberFormatException e) {
		}
		return false;
	}

	public static boolean isStringNumeric(String string) {
		String regexPattern = "^[0-9]+$";
		return string.matches(regexPattern);
	}
}
