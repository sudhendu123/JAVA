package com.sample.java.prgm;

public class SwapNumber {
	public static void main(String[] args) {
		xor();
		
	}

	public static void TempdVar() {
		float a = 1.18f, b = 2.69f;
		System.out.println("Before swapping");
		System.out.println("First number = " + a);
		System.out.println("Second number = " + b);
		// Value of a is assigned to temporary
		float temp = a;
		// Value of b is assigned to first
		a = b;
		// Value of temp (which contains the initial value of first) is assigned to second
		b = temp;
		System.out.println("After swapping");
		System.out.println("First number = " + a);
		System.out.println("Second number = " + b);
	}
	
	public static void withOutTempdVar() {
		float a = 18.0f, b = 28.5f;
		System.out.println("Before swapping:");
		System.out.println("First number = " + a);
		System.out.println("Second number = " + b);
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("After swapping:");
		System.out.println("First number = " + a);
		System.out.println("Second number = " + b);
	}
	
	public static void xor() {
		int num1=12, num2=10;
		num1 = num1 ^ num2;
        //num2 becomes 1010 = 10
        num2 = num1 ^ num2;
        //num1 becomes 0101 = 5
        num1 = num1 ^ num2;
		
        System.out.println("num1 ="+num1);
        System.out.println("num2 ="+num2);
        //5(0101) ^ 3(0011) = 6(0110); 
	}
}
