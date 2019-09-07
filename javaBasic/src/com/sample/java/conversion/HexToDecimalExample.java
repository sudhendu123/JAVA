package com.sample.java.conversion;

public class HexToDecimalExample {
	public static void main(String[] args) {
		System.out.println("hex F to decimal: "+Integer.parseInt("F",16));  
		System.out.println("Decimal of a is: "+getDecimal("a"));  
	}

	public static int getDecimal(String hex){  
	    String digits = "0123456789ABCDEF";  
	             hex = hex.toUpperCase();  
	             int val = 0;  
	             for (int i = 0; i < hex.length(); i++)  
	             {  
	                 char c = hex.charAt(i);  
	                 int d = digits.indexOf(c);  
	                 val = 16*val + d;  
	             }  
	             return val;  
	}
}
