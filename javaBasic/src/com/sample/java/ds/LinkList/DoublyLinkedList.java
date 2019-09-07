package com.sample.java.ds.LinkList;

public class DoublyLinkedList {

	private DLNode head;
	private DLNode tail;
	int size;
 
	public static void main(String args[])
	 {
	   DoublyLinkedList myLinkedlist = new DoublyLinkedList();
	   myLinkedlist.insertFirst(5);
	   myLinkedlist.insertFirst(6);
	   myLinkedlist.insertFirst(7);
	   myLinkedlist.insertFirst(1);
	   myLinkedlist.insertLast(2);
	   myLinkedlist.printLinkedListForward();
	   myLinkedlist.printLinkedListBackward();
	   
	   System.out.println("================");
	   // Doubly Linked list will be 
	   // 1 ->  7 -> 6 -> 5 -> 2
	   
	   DLNode node=new DLNode();
	   node.data=1;
	   myLinkedlist.deleteAfter(node);
	   myLinkedlist.printLinkedListForward();
	   myLinkedlist.printLinkedListBackward();
	   // After deleting node after 1,doubly Linked list will be 
	   // 2 -> 1 -> 6 -> 5
	   System.out.println("================");
	   myLinkedlist.deleteFirst();
	   myLinkedlist.deleteLast();
	   
	   // After performing above operation, doubly Linked list will be 
	   //  6 -> 5
	   myLinkedlist.printLinkedListForward();
	   myLinkedlist.printLinkedListBackward();
	 }
	
	public boolean isEmpty() {
		return (head == null);
	}
 
	// used to insert a node at the start of linked list
	public void insertFirst(int data) {
		DLNode newNode = new DLNode();
		newNode.data = data;
		newNode.next = head;
		newNode.prev=null;
		if(head!=null)
			head.prev=newNode;
		head = newNode;
		if(tail==null)
			tail=newNode;
		size++;
	}
 
	// used to insert a node at the start of linked list
	public void insertLast(int data) {
		DLNode newNode = new DLNode();
		newNode.data = data;
		newNode.next = null;
		newNode.prev=tail;
		if(tail!=null)
			tail.next=newNode;
		tail = newNode;
		if(head==null)
			head=newNode;
		size++;
	}
	// used to delete node from start of Doubly linked list
	public DLNode deleteFirst() {
 
		if (size == 0) 
			throw new RuntimeException("Doubly linked list is already empty");
		DLNode temp = head;
		head = head.next;
		head.prev = null;
		size--;
		return temp;
	}
 
	// used to delete node from last of Doubly linked list
	public DLNode deleteLast() {
 
		DLNode temp = tail;
		tail = tail.prev;
		tail.next=null;
		size--;
		return temp;
	}
 
 
	// Use to delete node after particular node
	public void deleteAfter(DLNode after) {
		DLNode temp = head;
		while (temp.next != null && temp.data != after.data) {
			temp = temp.next;
		}
		if (temp.next != null)
			temp.next.next.prev=temp;
		temp.next = temp.next.next;
 
	}
 
	// For printing Doubly Linked List forward
	public void printLinkedListForward() {
		System.out.println("Printing Doubly LinkedList (head --> tail) ");
		DLNode current = head;
		while (current != null) {
			current.displayNodeData();
			current = current.next;
		}
		System.out.println();
	}
 
	// For printing Doubly Linked List forward
	public void printLinkedListBackward() {
		System.out.println("Printing Doubly LinkedList (tail --> head) ");
		DLNode current = tail;
		while (current != null) {
			current.displayNodeData();
			current = current.prev;
		}
		System.out.println();
	}
}

class DLNode {
	public int data;
	public DLNode next;
	public DLNode prev;
 
	public void displayNodeData() {
		System.out.println("{ " + data + " } ");
	}
}
