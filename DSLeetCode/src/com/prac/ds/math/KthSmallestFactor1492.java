package com.prac.ds.math;

/**
 * Kth Smallest Factor GIven two positive integers N and K. You have to find the
 * Kth smallest factor of N. A factor of N is a positive integer which divides
 * N. Output the Kth smallest factor of N if it exists otherwise print -1.
 *
 * Example 1:
 * 
 * Input : N = 4 , K = 2 Output: 2 Explanation: All factors of 4 are 1,2 and 4.
 * Out of these 2 is the 2nd smallest. Example 2:
 * 
 * Input : N = 4 , K = 3 Output: 4 Explanation: All factors of 4 are 1,2 and 4.
 * Out of these 4 is the 3rd smallest.
 * 
 * The kth Factor of n You are given two positive integers n and k. A factor of
 * an integer n is defined as an integer i where n % i == 0.
 * 
 * Consider a list of all factors of n sorted in ascending order, return the kth
 * factor in this list or return -1 if n has less than k factors.
 * 
 * Example 1:
 * 
 * Input: n = 12, k = 3 Output: 3 Explanation: Factors list is [1, 2, 3, 4, 6,
 * 12], the 3rd factor is 3. Example 2:
 * 
 * Input: n = 7, k = 2 Output: 7 Explanation: Factors list is [1, 7], the 2nd
 * factor is 7. Example 3:
 * 
 * Input: n = 4, k = 4 Output: -1 Explanation: Factors list is [1, 2, 4], there
 * is only 3 factors. We should return -1.
 */
public class KthSmallestFactor1492 {
	
	public static void main(String[] args) {
		System.out.println("samllest factor:"+kThSmallestFactor(12, 6));
		//System.out.println("samllest factor:"+kThSmallestFactor(4, 3));
		//System.out.println("samllest factor:"+kThSmallestFactor(4, 4));
	}
	
	public static int kThSmallestFactor(int N , int K) {
	       int count =0;
	       for(int i =1;i<=N;i++){
	           if(N%i==0){
	               count++;
	           }
	           if(count==K){
	               return i;
	           }
	       }
	       return -1;
	    }

}
