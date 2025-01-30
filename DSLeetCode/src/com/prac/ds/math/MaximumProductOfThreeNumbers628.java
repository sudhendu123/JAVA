package com.prac.ds.math;

import java.util.Arrays;

/**
 * 
 * Given an integer array nums, find three numbers whose product is maximum and
 * return the maximum product.
 * 
 * Example 1: Input: nums = [1,2,3] Output: 6 Explanation: Subsequence
 * containing elements {2, 3} gives maximum product:2*3 = 6
 * 
 * Example 2: Input: nums = [1,2,3,4] Output: 24 Explanation : 1*2*3*4=24
 * Example 3: Input: nums = [-1,-2,-3] Output: -6 Explanation : 1*-2*-3=-6
 * 
 * Input: N = 6, K = 4 arr[] = {1, 2, -1, -3, -6, 4} Output: 144 Explanation:
 * Subsequence containing {2, -3, -6, 4} gives maximum product:2*(-3)*(-6)*4 =
 * 144
 *
 */
public class MaximumProductOfThreeNumbers628 {
	
	public static void main(String[] args) {
		int num[]= {21,111,41,31,54,23,78};
		System.out.println("max product:"+maximumProduct(num));
		System.out.println("max product:"+maximumProduct2(num));
	}

	/**
	 * Approach 1 There could be 3 cases:
	 * 
	 * All numbers are positive :- In this case product of 3 max numbers will give
	 * the desired result. All numbers are negative :- Similarly, in this case the
	 * max product of 3 numbers is possible when all 3 numbers is minimum. Mix of
	 * +ve & -ve numbers :- This is the case where the max product of 3 numbers has
	 * 2 possible solution: (i) one solution could be product of 3 max. numbers.
	 * (ii) product of 2 min. numbers which will result in +ve numbers & then there
	 * product with a max. number
	 */

	public static int maximumProduct(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		// in case all the numbers are +ve / -ve then this'll be the desired result.
		int positiveProduct = nums[len - 1] * nums[len - 2] * nums[len - 3];
		// in case of mix of +ve & -ve numbers then product of two min & a max number
		// can also be a possible result.
		int negativeProduct = nums[0] * nums[1] * nums[len - 1];
		return Math.max(positiveProduct, negativeProduct);
	}

	/**
	 * Approach 2 => product of 2 min. numbers which will result in +ve numbers &
	 * then there product with a max. number. This can be achieved by linear
	 * traversal over given array, while keeping few variables 2 to store minimum
	 * numbers & 3 for storing maximum numbers.
	 */
	public static int maximumProduct2(int[] nums) {
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

		for (int n : nums) {
			// to get the minimum two numbers
			if (n < min1) {
				min2 = min1;
				min1 = n;
			} else if (n < min2) {
				min2 = n;
			}
			// to get the maximum 3 numbers
			if (n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (n > max2) {
				max3 = max2;
				max2 = n;
			} else if (n > max3) {
				max3 = n;
			}
		}
		return Math.max(max1 * max2 * max3, min1 * min2 * max1);
	}
}
