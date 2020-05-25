package com.sample.java.prgm;

public class SquareRoot {

	public static void main(String[] args) {
		int number=4;
		double temp;

		double sr = number / 2;

		do {
			temp = sr;
			sr = (temp + (number / temp)) / 2;
		} while ((temp - sr) != 0);

		System.out.println("sr :"+sr);
	}
}
