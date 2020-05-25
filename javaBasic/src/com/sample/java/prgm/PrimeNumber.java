package com.sample.java.prgm;

public class PrimeNumber {

	//A prime number is a whole number greater than 1 whose only factors are 1 and itself. 
	public static void main(String[] args) {
		int n = 1, i, c = 0;
		for (i = 1; i <= n; i++) {
			if (n % i == 0) {
				c++;
			}
		}

		if (c == 2) {
			System.out.println(n + " is a Prime number");
		} else {
			System.out.println(n + " is not a Prime number");
		}
	}

}
