package com.sample.java.string;

public class StringSplit {
	public static void main(String[] args) {
		String file = "abc-def-ghi-21.xml";
		int dotIndex = file.indexOf('.');
		System.out.println("dotIndex :" + dotIndex);
		String[] stee = file.split("[- .]+");

		System.out.println("stee " + stee[3]);

		String str = "i@am@bond@man";
		//The limit parameter controls the number of times the pattern is applied 
		//and therefore affects the length of the resulting array. 
		String[] arrOfStr = str.split("@", 3); //same result with 5, -2

		for (String a : arrOfStr)
			System.out.println(a);
		String strMain = "Alpha, Beta, Delta, Gamma, Sigma";
	    String[] arrSplit_2 = strMain.split(", ", 3);
	    for (int i=0; i < arrSplit_2.length; i++){
	      System.out.println(arrSplit_2[i]);
	    }
	    System.out.println("=========================regex========");
	    String str1 = "word1, word2 word3@word4?word5.word6"; 
        String[] arrOfStr1 = str1.split("[, @?.]+"); //split with all special char
  
        for (String a : arrOfStr1) 
            System.out.println(a); 
          
	}

}
