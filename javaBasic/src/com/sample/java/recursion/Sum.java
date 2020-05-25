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
}
