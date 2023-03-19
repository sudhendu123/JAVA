package com.prac.ds.math;

public class PalindromeNumber9 {

	public static void main(String[] args) {
		System.out.println(" pallindrome :" + isPalindrome(121));
		System.out.println(" pallindrome :" + isPalindrome(122));
	}

	public static String isPalindrome(int n) {
		String rev = "";
		String val = String.valueOf(n);
		for (int i = val.length() - 1; i >= 0; i--) {
			rev = rev + val.charAt(i);
		}
		if (val.equals(rev)) {
			return "Yes";
		} else
			return "No";

	}

}
