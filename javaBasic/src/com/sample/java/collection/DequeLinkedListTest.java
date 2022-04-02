package com.sample.java.collection;

import java.util.Deque;
import java.util.LinkedList;

public class DequeLinkedListTest {

	public static void main(String[] args) {
		//Deque<String> dq = new ArrayDeque<String>();  
		Deque<String> dq = new LinkedList<String>(); 
		dq.add("Ravi");    
		dq.add("Vijay");     
		dq.add("Ajay");    
		   
		   System.out.println(dq);
	}
}
