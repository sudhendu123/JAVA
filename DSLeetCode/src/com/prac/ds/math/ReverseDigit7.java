package com.prac.ds.math;

/**
 * 
 * 1234
 *reverse  =4321
 */
public class ReverseDigit7 {

	public static void main(String[] args) {
		
		System.out.println(" 1234 reverse :"+reverse_digit(1234));
	}
	
	  public static long reverse_digit(long n)
	    {
	        // Code here
	        long rem=0,rev=0;
	        while(n>0){
	            rem=n%10;
	            rev=rev*10+rem;
	            n=n/10;
	        }
	        return rev;
	    }
}
