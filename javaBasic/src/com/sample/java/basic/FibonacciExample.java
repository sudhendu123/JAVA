package com.sample.java.basic;

public class FibonacciExample {
	static int n1 = 0, n2 = 1, n3 = 0;

	public static void main(String[] args) {
		//int n1 = 0;
		//int n2 = 1;
		int count = 10;
		System.out.print(n1 + " " + n2);
		printFibonacci(count - 2);
		System.out.println();
		fibo();
		System.out.println();
		System.out.println(fibonacci(6));
	}

	public static void fibo() {
		int n1 = 0, n2 = 1, n3, i, count = 10;
		System.out.print(n1 + " " + n2);// printing 0 and 1

		for (i = 2; i < count; ++i)// loop starts from 2 because 0 and 1 are already printed
		{
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}

	}

	static void printFibonacci(int count) {
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		if (count > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFibonacci(count - 1);
		}
	}

	public static int fibonacci(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

}
