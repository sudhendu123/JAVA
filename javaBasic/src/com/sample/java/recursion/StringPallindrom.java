package com.sample.java.recursion;

public class StringPallindrom {

	public static void main(String[] args) {
			System.out.println(isPalindrome("RADARA"));
	}

	static Boolean helper(int l, int r, String s) {
		// base condition
		// l : left pointer, r : right pointer
		if (l >= r)
			return true;

		// base condition
		// when character at s[left] is not equal to character at s[right] that means it
		// is not a palindrome thus return false
		if (s.charAt(l) != s.charAt(r))
			return false;

		// recursion call
		return helper(l + 1, r - 1, s);
	}

	public static Boolean isPalindrome(String s) {
		// Write your code here..
		// here we are going to use two pointer approach
		// left pointer starting from first index 0
		// right pointer starting from last index s.size() - 1
		return helper(0, s.length() - 1, s);
	}

	/*
	 * time complexity : O(n) space complexity : O(n)
	 */

}
