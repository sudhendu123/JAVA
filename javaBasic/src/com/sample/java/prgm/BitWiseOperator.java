package com.sample.java.prgm;

public class BitWiseOperator {
	
	public static void main(String[] args) {
		if(1>2&1<2) {
			//& <-- verifies both operands
			System.out.println("checks both conditions(1>2)&(1<2) ");
		}else if(2>3&&1<2) {
			//&& <-- stops evaluating if the first operand evaluates to false since the result will be false
			System.out.println("check 1st if false then false");
		}else {
			System.out.println("all well");
		}
		
		int a = 4;
		int b = 7;
		System.out.println(a & b); // prints 4
		//meaning in an 32 bit system
		// 00000000 00000000 00000000 00000100
		// 00000000 00000000 00000000 00000111
		// ===================================
		// 00000000 00000000 00000000 00000100
		
		int a1=12; // binary representation of 12 is 1100

		int b1=6; // binary representation of 6 is 0110

		int c=(a1 & b1); // binary representation of (12 & 6) is 0100
		System.out.println(c);
		
		/**
		 * 
		 * 
Operation     Meaning                       Note
---------     -------                       ----
   a && b     logical AND                    short-circuiting
   a || b     logical OR                     short-circuiting
   a &  b     boolean logical AND            not short-circuiting
   a |  b     boolean logical OR             not short-circuiting
   a ^  b     boolean logical exclusive OR
  !a          logical NOT

short-circuiting        (x != 0) && (1/x > 1)   SAFE
not short-circuiting    (x != 0) &  (1/x > 1)   NOT SAFE
		 
		 * 
		 * 
		 * 
		 * 
		 */
	}

}
