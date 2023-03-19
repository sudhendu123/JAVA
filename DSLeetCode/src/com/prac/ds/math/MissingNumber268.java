package com.prac.ds.math;

import java.util.Arrays;

/**
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 * 
 * Example 1: Input: nums = [3,0,1] Output: 2 Explanation: n = 3 since there are
 * 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in
 * the range since it does not appear in nums.
 * 
 * Example 2: Input: nums = [0,1] Output: 2 Explanation: n = 2 since there are 2
 * numbers, so all numbers are in the range [0,2]. 2 is the missing number in
 * the range since it does not appear in nums.
 * 
 * Example 3: Input: nums = [9,6,4,2,3,5,7,0,1] Output: 8 Explanation: n = 9
 * since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the
 * missing number in the range since it does not appear in nums.
 */

public class MissingNumber268 {
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		System.out.println(" missing: "+missingNumber(arr,6));
		System.out.println(" missing: "+missingNumber(arr));
		
	}

	// Function to find the smallest positive number missing from the array.
	static int missingNumber(int arr[],int size) {
		// Your code here
		Arrays.sort(arr);
		//int size=arr.length;
		int n = 1;
		for (int i = 0; i < size; i++) {
			if (arr[i] == n) {
				n++;
			}
		}
		return n;
	}
	
	 public static int missingNumber(int[] nums) {
	        int actualSum = 0, an = nums.length, n = nums.length + 1;
	        for(int a : nums) actualSum += a;
	        return (n * (0 + an) / 2) - actualSum;
	    }
}
