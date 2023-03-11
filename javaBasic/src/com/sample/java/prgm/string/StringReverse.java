package com.sample.java.prgm.string;

public class StringReverse {
	public static void main(String[] args) {
		System.out.println(StringReverse.reverseString("String reverse is this "));  
		System.out.println(StringReverse.reverseStringItr("String reverse is this "));  
	}
	
	public static String reverseStringItr(String str){  
	    char ch[]=str.toCharArray();  
	    String rev="";  
	    for(int i=ch.length-1;i>=0;i--){  
	        rev+=ch[i];  
	    }  
	    return rev;  
	}  
	
	public static String reverseString(String str){  
	    StringBuilder sb=new StringBuilder(str);  
	    sb.reverse();  
	    return sb.toString();  
	}  

}
