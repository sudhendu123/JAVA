package com.sample.java.conversion;

public class DecimalToOctalExample {

	public static void main(String[] args) {
		System.out.println("decimal 10 to octal : "+Integer.toOctalString(10));  
		System.out.println("Decimal to octal of 8 is: "+toOctal(8));  
	}
	
	public static String toOctal(int decimal){    
	    int rem;   
	    String octal="";  
	    char octalchars[]={'0','1','2','3','4','5','6','7'};  
	    while(decimal>0)  
	    {  
	       rem=decimal%8;   
	       octal=octalchars[rem]+octal;   
	       decimal=decimal/8;  
	    }  
	    return octal;  
	}    
}

