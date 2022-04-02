package com.sample.java.recursion;

public class Sum {

	public static void main(String[] args) {
		System.out.println("SUM ="+sum(2));
	}
	
	public static int sum(int n) {
	    if (n >= 1) {
	        return sum(n - 1) + n;
	    }
	    return n;
	}
	/**
	 * sum(n-1)+n
	 * n=2
	 * sum(2)=sum(1)+2=1+2=3
	 * 
	 * n=1
	 * sum(1)=sum(0)+1=0+1=1
	 * 
	 * sum(0)=0
	 */
}
