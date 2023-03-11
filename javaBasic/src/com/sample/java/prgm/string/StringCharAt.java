package com.sample.java.prgm.string;

public class StringCharAt {
	
	public static void main(String[] args) {
		 String str = "Welcome to Java portal";  
	        int count = 0;  
	        for (int i=0; i<=str.length()-1; i++) {  
	            if(str.charAt(i) == 't') {  
	                count++;  
	            }  
	        }  
	        System.out.println("Frequency of t is: "+count);  
	}

}
