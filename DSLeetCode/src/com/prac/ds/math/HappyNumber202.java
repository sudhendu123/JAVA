package com.prac.ds.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a number N find whether its a happy number or not. A number is called
 * happy if it leads to 1 after a sequence of steps wherein each step, the
 * number is replaced by the sum of squares of its digit that is if we start
 * with Happy Number and keep replacing it with digits square sum, we reach 1.
 *
 * Example 1: Input: N = 19 Output: 1 Explanation: 19 is a Happy Number, 1^2 +
 * 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1 As we reached to
 * 1, 19 is a Happy Number.
 * 
 * Example 2:
 * 
 * Input: N = 20 Output: 0 Explanation: We can never reach to 1 by repeating the
 * mentioned steps.
 */
public class HappyNumber202 {

	public static void main(String[] args) {
		System.out.println("19 is happy:" + isHappy(19));

		System.out.println("91 is happy:" + isHappy(91));

		System.out.println("20 is happy:" + isHappy(20));

	}

	public static int isHappy(int n) {
		Set<Integer> seen = new HashSet<>();

		// Loop until either n becomes 1 (in which case n is a happy number) or n is
		// seen again (in which case n is not a happy number)

		while (n != 1 && !seen.contains(n)) {
			// Add n to the set of seen numbers
			seen.add(n);

			// Compute the sum of the squares of the digits of n
			int sum = 0;
			while (n != 0) {
				int digit = n % 10;
				sum = sum + digit * digit;
				n = n / 10;
			}

			// Update n with the sum of the squares of its digits

			n = sum;
		}

		// If n is 1, it is a happy number; otherwise, it is not
		if (n == 1)
			return 1;
		else
			return 0;
	}

}
