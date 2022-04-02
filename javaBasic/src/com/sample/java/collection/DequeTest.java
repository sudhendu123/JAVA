package com.sample.java.collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {

	public static void main(String[] args) {
		Deque<Bookk> set = new ArrayDeque<Bookk>();
		// Creating Bookks
		Bookk b1 = new Bookk(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Bookk b2 = new Bookk(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Bookk b3 = new Bookk(103, "Operating System", "Galvin", "Wiley", 6);
		// Adding Bookks to Deque
		set.add(b1);
		set.add(b2);
		set.add(b3);
		// Traversing ArrayDeque
		for (Bookk b : set) {
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}
		
		Deque<String> deque=new ArrayDeque<String>();  
	    deque.offer("arvind");  
	    deque.offer("vimal");  
	    deque.add("mukul");  
	    deque.offerFirst("jai");  
	    System.out.println("After offerFirst Traversal...");  
	    for(String s:deque){  
	        System.out.println(s);  
	    }  
	    //deque.poll();  
	    //deque.pollFirst();//it is same as poll()  
	    deque.pollLast();  
	    System.out.println("After pollLast() Traversal...");  
	    for(String s:deque){  
	        System.out.println(s);  
	    }  
	    
	    
	}

}

class Bookk {    
int id;    
String name,author,publisher;    
int quantity;    
public Bookk(int id, String name, String author, String publisher, int quantity) {    
    this.id = id;    
    this.name = name;    
    this.author = author;    
    this.publisher = publisher;    
    this.quantity = quantity;    
}    
}    