package com.sample.java.net.newfeature;

import static java.lang.System.*;

import java.io.PrintStream;    
public class StaticImport {
	
	public static void main(String args[]){  
		
		/**
		 * PrintStream
		 * public void println() {
        		newLine();
    		}
		 */
		
	     //public static final PrintStream out = null;
		   out.println("Hello");//Now no need of System.out  
		   out.println("Java");  
		  
		 }   

}
