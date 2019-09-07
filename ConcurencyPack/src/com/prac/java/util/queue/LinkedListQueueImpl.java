package com.prac.java.util.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueImpl {

	
	public static void main(String[] args) {
		Queue q=new LinkedList();
		q.add(1);
		q.add(3);
		q.add(2);
		q.add(4);
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q);
		//FIFO:As we are adding in an ordered manner and when we remove elements its removes the first element.
	}
}
