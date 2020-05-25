package com.sample.java.string;

public class StringPalindrome {
	
	public static void main(String[] args) {
		System.out.println(StringPalindrome.isPalindrome("yoy"));	
	}

	public static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String rev = sb.toString();
		if (str.equals(rev)) {
			return true;
		} else {
			return false;
		}
	}
}
