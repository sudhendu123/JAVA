package com.prac.ds.math;

import java.util.Arrays;

/**
 * Given an integer array nums of size n, return the minimum number of moves
 * required to make all array elements equal. In one move, you can increment n -
 * 1 elements of the array by 1. Example 1: Input: nums = [1,2,3] Output: 3
 * Explanation: Only three moves are needed (remember each move increments two
 * elements): [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 * 
 * Example 2: Input: nums = [1,1,1] Output: 0
 *
 */
public class MinimumMovesToEqualArrayElements453 {

	public static void main(String[] args) {
		int numberA[] = { 1, 2, 3 };
		System.out.println(" number of moves required to make them equal:" + minMoves(numberA));

	}

	public static int minMoves(int[] nums) {
		Arrays.sort(nums);
		int a = 0;
		for (int i = 0; i < nums.length; i++) {
			int b = -1 * (nums[0] - nums[i]);
			a = a + b;
		}
		return a;
	}

}
