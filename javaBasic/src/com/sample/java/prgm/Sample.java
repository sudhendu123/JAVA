package com.sample.java.prgm;

import java.util.HashMap;
import java.util.Map;

public class Sample {
	public static void main(String[] args) {
		revrese("abcc heba");
		System.out.println(reverseStringChar("qwe rt"));
	}

	public static void revrese(String str) {
		String word[]=str.split("\\s");
		StringBuilder sb=new StringBuilder();
		String rev="";
		for(int i=word.length-1;i>=0;i--) {
			//sb.append(word[i]);
			rev=rev+word[i];
		}
		System.out.println(rev);
	}
	
	public static String reverseStringChar(String str) {
		char ch[] = str.toCharArray();
		String rev = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			rev += ch[i];
		}
		return rev;
	}

}
