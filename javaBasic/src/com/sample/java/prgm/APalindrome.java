package com.sample.java.prgm;

public class APalindrome {

	public static void main(String[] args) {
		palindromeWhile(121);
		palindromeFor(121);
		palindromeString("aba");
	}

	public static void palindromeWhile(int n) {
		int rem, rev = 0, temp;
		temp = n;
		// reversed integer is stored in variable
		while (n != 0) {
			rem = n % 10;
			rev = rem+rev * 10;
			n = n / 10;
		}
		// palindrome if orignalInteger(temp) and reversedInteger(rev) are equal
		if (temp == rev)
			System.out.println(temp + " is a palindrome.");
		else
			System.out.println(temp + " is not a palindrome.");
	}

	public static void palindromeFor(int n) {
		int rev = 0, rem, temp;
		for (temp = n; n != 0; n /= 10) {
			rem = n % 10;
			rev = rem+rev * 10 ;
		}
		// palindrome if temp and sum are equal
		if (temp == rev)
			System.out.println(temp + " is a palindrome.");
		else
			System.out.println(temp + " is not a palindrome.");
	}

	public static void palindromeString(String s) {
		// reverse the given String
		String reverse = new StringBuffer(s).reverse().toString();
		// checks whether the string is palindrome or not
		if (s.equals(reverse))
			System.out.println("Yes, it is a palindrome");
		else
			System.out.println("No, it is not a palindrome");
	}
}
