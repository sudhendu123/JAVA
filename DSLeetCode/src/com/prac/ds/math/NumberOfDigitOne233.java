package com.prac.ds.math;

/**
 * 
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 *
 *Example 1:

Input: n = 13
Output: 6
Example 2:

Input: n = 0
Output: 0
 */
public class NumberOfDigitOne233 {

	public static void main(String[] args) {
		System.out.println("count numer of 1:"+countDigitOneOld(13));
		System.out.println("count numer of 1:"+countDigitOne(13));
	}

	public static int countDigitOneOld(int n) {
		int ones = 0, m = 1, r = 1;
		while (n > 0) {
			ones += (n + 8) / 10 * m + (n % 10 == 1 ? r : 0);
			r += n % 10 * m;
			m *= 10;
			n /= 10;
		}
		return ones;
	}

	public static int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)
			ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
		return ones;
	}
}
