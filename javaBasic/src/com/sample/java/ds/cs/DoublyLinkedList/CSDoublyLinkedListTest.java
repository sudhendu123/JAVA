package com.sample.java.ds.cs.DoublyLinkedList;

public class CSDoublyLinkedListTest {
	
	public static void main(String[] args) {
		CSDoublyLinkedList dll = new CSDoublyLinkedList();
		dll.insertFirst(1);
		dll.insertEnd(5);
		dll.insertEnd(6);
		dll.insertFirst(2);
		dll.insertFirst(3);
		dll.insertAtIndex(4, 4);
		dll.deleteFirst();
		dll.deleteLast();
		System.out.println(" displayForward :");
		dll.displayForward();
		dll.deleteAtIndex(2);
		System.out.println(" After displayForward :");
		dll.displayForward();
		dll.displayBackward();
	}

}
