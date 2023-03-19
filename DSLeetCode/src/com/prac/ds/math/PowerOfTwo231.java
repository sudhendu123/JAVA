package com.prac.ds.math;

/**
 * 
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 *Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
 */
public class PowerOfTwo231 {
	public static void main(String[] args) {
		System.out.println("4 is power of 2:"+isPowerOfTwo(4));
		System.out.println("6 is power of 2:"+isPowerOfTwo2(6));
	}
	
	public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n != 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
	
	 public static boolean isPowerOfTwo2(int n) {
	       if(n==1) return true;
	       if(n<1) return false;
	       if(n%2!=0) {
	           return false;
	       } 
	        return (isPowerOfTwo(n/2));
	    }

}
