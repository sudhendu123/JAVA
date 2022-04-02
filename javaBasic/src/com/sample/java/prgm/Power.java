package com.sample.java.prgm;

//2^5=2x2x2x2x2=32 , 5^2=5x5=25
public class Power {

	public static void main(String[] args) {
		prowerFor();
		powerWhile();
		poerFunc();
	}

	static void prowerFor() {

		// Here number is the base and p is the exponent
		int number = 2, p = 5;
		long result = 1;

		// Copying the exponent value to the loop counter
		int i = p;
		for (; i != 0; --i) {
			result =result * number;
		}

		// Displaying the output
		System.out.println(number + "^" + p + " = " + result);
	}

	static void powerWhile() {
		int number = 5, p = 2;
		long result = 1;

		int i = p;
		while (i != 0) {
			result *= number;
			--i;
		}
		System.out.println(number + "^" + p + " = " + result);
	}

	static void poerFunc() {
		int number = 10, p = 3;
		double result = Math.pow(number, p);
		System.out.println(number + "^" + p + " = " + result);
	}

}
