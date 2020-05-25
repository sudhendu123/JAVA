package com.sample.java.prgm;

import java.util.Scanner;

public class SumOfDigits {

	int sum = 0;

	public static void main(String arg[]) {

		long n,res;
		SumOfDigits s=new SumOfDigits();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number ");
		n=sc.nextLong();
		 
		System.out.println("Sum of digits "+s.sumRecurssion(n));
	}

	public static void sumDigitFor() {

		long n, sum;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number ");
		n = sc.nextLong();
		for (sum = 0; n != 0; n /= 10) {
			sum += n % 10;
		}
		System.out.println("Sum of digits " + sum);
	}

	public static void sumDigitWhile() {

		String arr[] = { "123" };
		long n, sum = 0;
		System.out.println("Enter a number ");
		n = Long.parseLong(arr[0]);
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		System.out.println("Sum of digits " + sum);
	}

	int sumRecurssion(long num) {

		if (num != 0) {
			sum += num % 10;
			num /= 10;
			sumRecurssion(num);
		}
		return sum;
	}
}
