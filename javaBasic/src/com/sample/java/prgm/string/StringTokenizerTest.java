package com.sample.java.prgm.string;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("hello people of the world"," ");
		StringTokenizer st1 = new StringTokenizer("hello people of the world"," ");
		
	     while (st.hasMoreTokens()) {  
	         System.out.println(st.nextToken());  
	     }
	     
	     for(;st1.hasMoreTokens();) {
	    	 System.out.println(st1.nextToken());
	     }
	     st = new StringTokenizer("who is this"," ");
	     System.out.println("Next token is : " + st.nextToken(" "));
	}

}
