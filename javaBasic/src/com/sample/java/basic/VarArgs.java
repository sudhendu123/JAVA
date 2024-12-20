package com.sample.java.basic;
import static java.lang.System.out;
public class VarArgs {
	
	public static void main(String[] args) {
		display(500,"hello");//one argument   
		display(1000,"my","name","is","varargs");//four arguments
		varArgs(1,2,3);
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
	
	public static void varArgs(int...strings)  {
		int[] ex = strings;	
		
		for(int e:ex) {
			System.out.println(e);
		}
		
	}

}
