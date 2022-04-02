package com.sample.java.prgm;

/**
 * 
 * The switch statement works with byte, short, int, long, enum types, String 
 * and some wrapper types like Byte, Short, Int, and Long. Since Java 7,
 *  you can use strings and enum in the switch statement.
 *
 *The case value must be of switch expression type only.
 * The case value must be literal or constant. It doesn't allow variables.
 * 
 * The case values must be unique. In case of duplicate value, it renders compile-time error.
 */
public class SwitchTest {
	
	public static void main(String[] args) {
		switchtest();
		System.out.println("-------------------------switchTestWithOutDefault-------------------");
		switchTestWithOutDefault();
		System.out.println("-------------------------switchStringTest-------------------");
		switchStringTest();
		System.out.println("-------------------------switchEnumTest-------------------");
		switchEnumTest();
		System.out.println("-------------------------switchWrapperTest-------------------");
		switchWrapperTest();
	}
	
	public static void switchtest() {
		//Declaring a variable for switch expression  
	    int number=20;  
	    //Switch expression  
	    switch(number){  
	    //Case statements  
	    case 10: System.out.println("10");  
	    break;  
	    case 20: System.out.println("20");  
	    break;  
	    case 30: System.out.println("30");  
	    break;  
	    //Default case statement  
	    default:System.out.println("Not in 10, 20 or 30");  
	}
	}
	
	public static void switchTestWithOutDefault() {
	
		int number=20;  
	    //switch expression with int value  
	    switch(number){  
	    //switch cases without break statements  
	    case 10: System.out.println("10");  
	    case 20: System.out.println("20");  
	    case 30: System.out.println("30");  
	    default:System.out.println("Not in 10, 20 or 30");  
	    }  
	}
	
	public static void switchStringTest() {
		//Declaring String variable  
	    String levelString="Expert";  
	    int level=0;  
	    //Using String in Switch expression  
	    switch(levelString){    
	    //Using String Literal in Switch case  
	    case "Beginner": level=1;  
	    break;    
	    case "Intermediate": level=2;  
	    break;    
	    case "Expert": level=3;  
	    break;    
	    default: level=0;  
	    break;  
	    }    
	    System.out.println("Your Level is: "+level);  
	}
	
	public static void switchEnumTest() {
		enum Day {  Sun, Mon, Tue, Wed, Thu, Fri, Sat  }   
		
		Day Now = Day.Fri;
		switch (Now)    
        {    
            case Sun:    
                System.out.println("Sunday");    
                break;    
            case Mon:    
                System.out.println("Monday");    
                break;    
            case Tue:    
                System.out.println("Tuesday");    
                break;         
            case Wed:    
                System.out.println("Wednesday");    
                break;    
            case Thu:    
                System.out.println("Thursday");    
                break;    
            case Fri:    
                System.out.println("Friday");    
                break;    
            case Sat:    
                System.out.println("Saturday");    
                break;    
        }    
	}
	
	public static void switchWrapperTest() {
		 Integer age = 18;        
         switch (age)  
         {  
             case (16):            
                 System.out.println("You are under 18.");  
                 break;  
             case (18):                
                 System.out.println("You are eligible for vote.");  
                 break;  
             case (65):                
                 System.out.println("You are senior citizen.");  
                 break;  
             default:  
                 System.out.println("Please give the valid age.");  
                 break;  
         }             
	}

}
