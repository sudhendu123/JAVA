package com.sample.java.basic;

import java.util.Scanner;

public class SwapNumber {
	
	public static void main(String[] args) {
		swapNumber();
		swapNumberWithout3rd();
	}
	public static void swapNumber() {
		int x, y, temp;
	      System.out.println("Enter x and y");
	      Scanner in = new Scanner(System.in);
	     
	      x = in.nextInt();
	      y = in.nextInt();
	     
	      System.out.println("Before Swapping\nx = "+x+"\ny = "+y);
	     
	      temp = x;
	      x = y;
	      y = temp;
	     
	      System.out.println("After Swapping\nx = "+x+"\ny = "+y);
	}
	
	public static void swapNumberWithout3rd() {
		int x, y;
	      System.out.println("Enter x and y");
	      Scanner in = new Scanner(System.in);
	 
	      x = in.nextInt();
	      y = in.nextInt();
	 
	      System.out.println("Before Swapping\nx = "+x+"\ny = "+y);
	 
	      x = x + y;
	      y = x - y;
	      x = x - y;
	 
	      System.out.println("After Swapping\nx = "+x+"\ny = "+y);
	}

}
