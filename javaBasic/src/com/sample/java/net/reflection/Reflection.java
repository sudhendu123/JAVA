package com.sample.java.net.reflection;

public class Reflection {
	
	 public static void main(String args[]) throws Exception {    
		  Class c=Class.forName("com.sample.java.net.reflection.RefelectLoad");    
		  System.out.println(c.getName());
		  RefelectLoad r=(RefelectLoad) c.newInstance();
		  r.method();
		  
		  RefelectLoad rl=new RefelectLoad();
		  Class c1=rl.getClass();    
		  System.out.println(c1.getName());  
		  
		  Class c2 = RefelectLoad.class;   
		   System.out.println(c2.getName());  
		  
		 }    

}
