package com.prac.ds.math;

/**
 * 
 * Your task is to implement the function atoi. The function takes a string(str)
 * as argument and converts it to an integer and returns it.
 * 
 * Example 1:
 * 
 * Input: str = 123 Output: 123
 * 
 * Example 2:
 * 
 * Input: str = 21a Output: -1 Explanation: Output is -1 as all characters are
 * not digit only.
 *
 */
public class StringToIntegerAtoi8 {
	public static void main(String[] args) {
		Integer.parseInt("abc");
		System.out.println(" string to integer:" + atoi("123"));
		System.out.println(" string to integer:" + atoi("123a"));
	}

	public static int atoi(String str) {

		int i = 0;
		int res = 0;
		int l = str.length();
		int sign = 1;
		if (str.charAt(0) == '-') {
			sign = -1;
			i++;
		}

		for (; i < l; i++) {
			if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9)
				res = 10 * res + str.charAt(i) - '0';

			else
				return -1;
		}

		return res * sign;

	}

	public static int parseInt(String s, int radix) throws NumberFormatException {
		radix = 10;
		/*
		 * WARNING: This method may be invoked early during VM initialization before
		 * IntegerCache is initialized. Care must be taken to not use the valueOf
		 * method.
		 */

		if (s == null) {
			throw new NumberFormatException("Cannot parse null string");
		}

		if (radix < Character.MIN_RADIX) {
			throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
		}

		if (radix > Character.MAX_RADIX) {
			throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
		}

		boolean negative = false;
		int i = 0, len = s.length();
		int limit = -Integer.MAX_VALUE;

		if (len > 0) {
			char firstChar = s.charAt(0);
			if (firstChar < '0') { // Possible leading "+" or "-"
				if (firstChar == '-') {
					negative = true;
					limit = Integer.MIN_VALUE;
				} else if (firstChar != '+') {
					throw new NumberFormatException(
							"For input string: \"" + s + "\"" + (radix == 10 ? "" : " under radix " + radix));
				}

				if (len == 1) { // Cannot have lone "+" or "-"
					throw new NumberFormatException(
							"For input string: \"" + s + "\"" + (radix == 10 ? "" : " under radix " + radix));
				}
				i++;
			}
			int multmin = limit / radix;
			int result = 0;
			while (i < len) {
				// Accumulating negatively avoids surprises near MAX_VALUE
				int digit = Character.digit(s.charAt(i++), radix);
				if (digit < 0 || result < multmin) {
					throw new NumberFormatException(
							"For input string: \"" + s + "\"" + (radix == 10 ? "" : " under radix " + radix));
				}
				result *= radix;
				if (result < limit + digit) {
					throw new NumberFormatException(
							"For input string: \"" + s + "\"" + (radix == 10 ? "" : " under radix " + radix));
				}
				result -= digit;
			}
			return negative ? result : -result;
		} else {
			throw new NumberFormatException(
					"For input string: \"" + s + "\"" + (radix == 10 ? "" : " under radix " + radix));
		}
	}
}
