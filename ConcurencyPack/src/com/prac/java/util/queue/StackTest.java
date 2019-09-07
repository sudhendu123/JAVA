package com.prac.java.util.queue;

import java.util.Stack;

public class StackTest {
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack();
		
		s.push(1);
		s.push(4);
		s.push(5);
		s.push(2);
		
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
	}

}
