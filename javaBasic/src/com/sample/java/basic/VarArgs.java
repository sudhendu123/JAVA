package com.sample.java.basic;
import static java.lang.System.*;
public class VarArgs {
	
	public static void main(String[] args) {
		display(500,"hello");//one argument   
		display(1000,"my","name","is","varargs");//four arguments
		
		int a=50;  
        Integer a2=new Integer(a);//Boxing  
  
        Integer a3=5;//Boxing  
        Integer i=new Integer(50);  
        int a1=i;  //unBoxing 
	}
	
	static void display(int num, String... values){  
		  
		  String[] val = values;
		  out.println("number is "+num+" val "+val[0]);
		  for(String s:values){  
		   out.println(s);  
		  }  
		 }  

}
