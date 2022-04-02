package com.sample.java.prgm;

public class LeapYear {

	public static void main(String[] args)  
    { 
        int year = 2018; 
        System.out.println( Year(2018)? "Leap Year" : 
                           "Not a Leap Year" ); 
    } 
	
	static boolean Year(int year) 
    { 
          
        if (year % 400 == 0) 
            return true; 
        
        if (year % 100 == 0) 
            return false; 
       
          
        if (year % 4 == 0) 
            return true; 
        return false; 
    } 
	
	public static void leapYear() {
		//year to leap year or not
//A leap year has 366 days (the extra day is the 29th of February), and it comes after every four years.
	       int year = 2016;
	       System.out.println();        
	       if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
	               System.out.println("Year " + year + " is a leap year");
	       else
	               System.out.println("Year " + year + " is not a leap year");
	               System.out.println();
	}
}
