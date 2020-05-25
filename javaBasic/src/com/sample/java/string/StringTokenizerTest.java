package com.sample.java.string;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("hello people of the world"," ");
		  
	     while (st.hasMoreTokens()) {  
	         System.out.println(st.nextToken());  
	     }
	     st = new StringTokenizer("who is this"," ");
	     System.out.println("Next token is : " + st.nextToken(" "));
	}

}
