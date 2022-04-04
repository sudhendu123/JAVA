package com.sample.java.string;

public class ReverseEachWordOfSentence {
	
	public static void main(String[] args) {
		System.out.println(ReverseEachWordOfSentence.reverseWord("who is this guy."));
		//ohw si siht .yug

	}

	public static String reverseWord(String str){  
	    String words[]=str.split("\\s");  
	    String reverseWord="";  
	    for(String w:words){  
	        StringBuilder sb=new StringBuilder(w);  
	        sb.reverse();  
	        reverseWord+=sb.toString()+" ";  
	    }  
	    return reverseWord.trim();  
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
