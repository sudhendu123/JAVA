package com.sample.java.conversion;

public class DecimalToHexExample {
	public static void main(String[] args) {
		System.out.println(" decemal 10 to hex : "+Integer.toHexString(10));  
		System.out.println("Hexadecimal of 10 is: "+toHex(10));  
	}

	public static String toHex(int decimal){    
	     int rem;  
	     String hex="";   
	     char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	    while(decimal>0)  
	     {  
	       rem=decimal%16;   
	       hex=hexchars[rem]+hex;   
	       decimal=decimal/16;  
	     }  
	    return hex;  
	}    
}
