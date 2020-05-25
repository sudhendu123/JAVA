package com.sample.java.prgm;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseStringRecursion("where are"));

		System.out.println(reverseString("where are"));

		System.out.println(reverseStringChar("where are"));

		System.out.println(reverseStringSwap("where are"));
	}

	public static String reverseStringRecursion(String str) {
		if (str.isEmpty())
			return str;
		System.out.println("str.substring(1) "+str.substring(1)+" char "+str.charAt(0));
		return reverseStringRecursion(str.substring(1)) + str.charAt(0);
	}

	public static String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		return sb.toString();
	}

	public static String reverseStringChar(String str) {
		char ch[] = str.toCharArray();
		String rev = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			rev += ch[i];
		}
		return rev;
	}

	public static String reverseStringSwap(String input) {
		char[] temparray = input.toCharArray();
		int left, right = 0;
		right = temparray.length - 1;

		StringBuilder st = new StringBuilder();

		for (left = 0; left < right; left++, right--) {
			// Swap values of left and right
			char temp = temparray[left];
			temparray[left] = temparray[right];
			temparray[right] = temp;
		}

		for (char c : temparray)
			st.append(c);
		return st.toString();
	}
}
