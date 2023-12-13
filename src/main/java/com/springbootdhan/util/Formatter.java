package com.springbootdhan.util;

public class Formatter {
	public static String formatYear(int year) {
		return String.valueOf(year);
	}

	public static String formatTwo(int value) {
		String zero="";
		if(value < 10)
			zero = "0";
		return String.valueOf(zero+value);
	}
}
