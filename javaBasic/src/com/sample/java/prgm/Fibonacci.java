package com.sample.java.prgm;

import java.util.Scanner;
//1+2=3,2+3=5,3+5=8
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
public class Fibonacci {

	public static void main(String[] args) {

		fibNonrecur();
		//fibRecur(10);
		//fib();
		//fiboRecursion();
	}
	

	public static void fibNonrecur() {
		int n1=0,n2=1,n3,i,number = 7;    
		for(i=2;i<number;++i)//loop starts from 2 because 0 and 1 are already printed    
		 {    
		  n3=n1+n2;    
		  n1=n2;    
		  n2=n3;
		  System.out.println(n3+":"+n1+":"+n2);
		 }  
	}
	
	public static void fibRecur(int n) {
		int n1=0,n2=1,n3;    
	    if(n>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.println("n3:"+n3);  
	         fibRecur(n-1);    
	    }    
	}
	
	public static void fib() {
		int n, first = 0, next = 1;

		System.out.println("Enter how may fibonnaci numbers to print");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		System.out.print("The first " + n + " Fibonacci numbers are: ");
		System.out.print(first + " " + next);
		int i = 1;
		while (i < n - 1) {
			int sum = first + next;
			first = next;
			next = sum;
			System.out.print(" " + sum);
			i++;
		}
	}

	public static void fiboRecursion() {
		int n;

		System.out.println("Enter how may fibonnaci numbers to print");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		for (int i = 0; i <= n - 1; ++i) {
			System.out.print(fibonaccinumber(i) + " ");
		}
	}

	public static int fibonaccinumber(int n) {

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonaccinumber(n - 1) + fibonaccinumber(n - 2);

	}
}
