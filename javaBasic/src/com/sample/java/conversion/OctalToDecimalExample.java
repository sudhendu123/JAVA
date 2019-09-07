package com.sample.java.conversion;

public class OctalToDecimalExample {

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("10",8));
		System.out.println("Decimal of 23 octal is: "+getDecimal(23));  
	}
	
	public static int getDecimal(int octal){    
	    //Declaring variable to store decimal number  
	    int decimal = 0;    
	    //Declaring variable to use in power  
	    int n = 0;    
	    //writing logic   
	    while(true){    
	      if(octal == 0){    
	        break;    
	      } else {    
	          int temp = octal%10;    
	          decimal += temp*Math.pow(8, n);    
	          octal = octal/10;    
	          n++;    
	       }    
	    }    
	    return decimal;    
	}    
}
