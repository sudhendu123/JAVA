package com.sample.java.recursion;

public class Fibonacci {

	static int n1 = 0, n2 = 1, n3 = 0;

	public static void main(String[] args) {
		int count = 15;
		System.out.print(n1 + " " + n2);// printing 0 and 1
		printFibo(count - 2);// n-2 because 2 numbers are already printed
	}

	public static void printFibo(int count) {
		if (count > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFibo(count - 1);
		}
	}
	
	//ex : 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377

}
