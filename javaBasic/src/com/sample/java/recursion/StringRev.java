package com.sample.java.recursion;

public class StringRev {
	
	public static void main(String[] args) {
		
		String str = "Welcome to Beginnersbook";
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
	}

	private static void helper(int index, char [] str) {
		  if (str == null || index >= str.length) {
		    return;
		  }
		  helper(index + 1, str);
		  System.out.print(str[index]);
		}
	
	public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
	
	
}
