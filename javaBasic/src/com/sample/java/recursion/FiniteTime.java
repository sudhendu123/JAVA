package com.sample.java.recursion;

public class FiniteTime {

	static int count = 0;

	public static void main(String[] args) {
		p();  
	}

	public static void p() {
		count++;
		if (count <= 5) {
			System.out.println("hello " + count);
			p();
		}
	}

}
