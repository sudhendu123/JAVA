package com.sample.java.collection;

import java.util.ListIterator;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stk2= new Stack<>();  
		//pushing elements into Stack  
		stk2.push("Mac Book");  
		stk2.push("HP");  
		stk2.push("DELL");  
		stk2.push("Asus");  
		System.out.println("Stack: " + stk2);  
		// Search an element  
		int location = stk2.search("HP");  
		System.out.println("Location of Dell: " + location); 
		// Access element from the top of the stack  
		String fruits = stk2.peek();  
		//prints stack  
		System.out.println("Element at top: " + fruits);  
		stk2.pop();
		System.out.println("Stack: " + stk2);
		
		//creating an instance of Stack class  
		Stack <Integer> stk = new Stack<>();  
		//pushing elements into stack  
		stk.push(119);  
		stk.push(203);  
		stk.push(988);  
		System.out.println("Iteration over the stack using forEach() Method:");  
		//invoking forEach() method for iteration over the stack  
		stk.forEach(n ->  
		{  
		System.out.println(n);  
		});  
		
		Stack<Integer> stk1 = new Stack<>();
		stk1.push(119);
		stk1.push(203);
		stk1.push(988);
		ListIterator<Integer> ListIterator = stk1.listIterator(stk.size());
		System.out.println("Iteration over the Stack from top to bottom:");
		while (ListIterator.hasPrevious()) {
			Integer avg = ListIterator.previous();
			System.out.println(avg);
		}
	}
}
