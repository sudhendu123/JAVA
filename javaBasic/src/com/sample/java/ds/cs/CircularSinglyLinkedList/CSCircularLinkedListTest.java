package com.sample.java.ds.cs.CircularSinglyLinkedList;

public class CSCircularLinkedListTest {

	public static void main(String[] args) {
		CSCircularLinkedList cll = new CSCircularLinkedList();
		cll.createCircularLinkedList();
		
		cll.insertLast(6);
		cll.insertLast(7);
		cll.insertFirst(2);
		
		cll.removeFirst();
		cll.removeLast();
		
		System.out.println("length: "+cll.length());
		cll.display();
	}
}
