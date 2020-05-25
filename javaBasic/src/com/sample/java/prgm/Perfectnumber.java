package com.sample.java.prgm;

public class Perfectnumber {

	
	public static void main(String[] args) {
		//28
		//Positive factors are; 1,2,4,7,14
		//Proper divisors of 6 are 1, 2, 3
		//Sum of its proper divisors = 1 + 2 + 3 = 6.
		int number = 6, rem, sum = 0;
		for (int i = 1; i <= (number - 1); i++)
	    {
	        rem = number % i;
		if (rem == 0)
	        {
	            sum = sum + i;
	        }
	    }
	    if (sum == number)
	        System.out.println("Entered Number is perfect number");
	    else
	        System.out.println("Entered Number is not a perfect number");
	}
}
