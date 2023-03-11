package com.sample.java.prgm.string;

public class StringLength {
	public static void main(String[] args) {
		String str="qwertyuiop";
		char charA[]=str.toCharArray();
		int count=0;
		for(char c:charA) {
			count++;
		}
		System.out.println("length:"+count);
	}

}
