package com.sample.java.prgm.string;

public class RotationString {
	/**
	 * 
	 
	Input : s = "GeeksforGeeks"
	        d = 2
	Output : Left (Or anticlockwise) rotate  : "eksforGeeksGe" 
	         Right (Or clockwise) rotate : "ksGeeksforGee"  


	Input : s = "qwertyu" 
	        d = 2
	Output : Left (Or anticlockwise) rotate : "ertyuqw"
	         Right (Or clockwise) rotate : "yuqwert"
	         */
	public static void main(String[] args) {
		String str1 = "avajava";
		String str2 = "javaava";
		System.out.println("Checking if a string is rotation of another");
		if (checkRotation(str1, str2)) {
			System.out.println("Yes " + str2 + " is rotation of " + str1);
		} else {
			System.out.println("No " + str2 + " is not rotation of " + str1);
		}
		
		String rot1 = "GeeksforGeeks";  
        System.out.println(leftrotate(rot1, 2)); 

        String rot2 = "GeeksforGeeks";  
        System.out.println(rightrotate(rot2, 2));  
	}

	public static boolean checkRotation(String st1, String st2) {
		if (st1.length() != st2.length()) {
			return false;
		}
		String st3 = st1 + st1;
		if (st3.contains(st2))
			return true;
		else
			return false;
	}
	
	// function that rotates s towards left by d  
    static String leftrotate(String str, int d) 
    { 
            String ans = str.substring(d) + str.substring(0, d); 
            return ans; 
    } 
  
    // function that rotates s towards right by d  
    static String rightrotate(String str, int d) 
    { 
            return leftrotate(str, str.length() - d); 
    } 
}
