package com.sample.java.ds.cs.SinglyLinkedList;

import com.sample.java.ds.cs.SinglyLinkedList.CSSinglyLinkedList.ListNode;

public class TestCSSinglyLinkedList {
	
	public static void main(String[] args) {
		CSSinglyLinkedList<Integer> sll = new CSSinglyLinkedList<Integer>();
		sll.head = new ListNode<Integer>(10);
		ListNode<Integer> second = new ListNode<Integer>(1);
		ListNode<Integer> third = new ListNode<Integer>(8);
		ListNode<Integer> fourth = new ListNode<Integer>(11);
		
		// Now we will connect them together to form a chain
		sll.head.next = second; // 10 --> 1
		second.next = third; // 10 --> 1 --> 8
		third.next = fourth; // 10 --> 1 --> 8 --> 11 --> null
		System.out.println("Added element : ");
		sll.display();
		
		System.out.println("Length is - " + sll.length());
		
//		// Now we will connect them together to form a chain
//		sll.head.next = second; // head --> 3
//		second.next = third; // head --> 3 --> 7
//		third.next = fourth; // head --> 3 --> 7 --> 13 --> null
		
		sll.insertFirst(13);
		sll.insertFirst(7);
		sll.insertFirst(3);
		sll.display();
		
		//insert at last
		// Now we will connect them together to form a chain
		// sll.head.next = second; // head --> 2
		// second.next = third; // head --> 2 --> 9
		// third.next = fourth; // head --> 2 --> 9 --> 12 --> null
		sll.insertLast(12);
		sll.insertLast(9);
		sll.insertLast(2);
		sll.display();
		
		//insert 5 at 5th position
		sll.insertAtPosition(5,5);
		sll.display();
		
		//deleteFirst
		System.out.println(sll.deleteFirst().data);
        System.out.println(sll.deleteFirst().data);
        sll.display();
        
        //deleteLast
        System.out.println(sll.deleteLast().data);
    	System.out.println(sll.deleteLast().data);
        sll.display();
        
        //deleteAtPosition
        sll.deleteAtPosition(3);
        sll.display();
        
        //searchElement
        System.out.println(sll.searchElement(13));
        
        //System.out.println("reverse : "+sll.reverse());
        ListNode<Integer> newHead = sll.reverse();
		sll.head = newHead;
		sll.display();
		
		//getMiddleNode
		ListNode<Integer> middleNode = sll.getMiddleNode();
		System.out.println("Middle node is - " + middleNode.data);
        
		//getNthNodeFromEnd
		ListNode<Integer> nthNodeFromEnd = sll.getNthNodeFromEnd(3);
		System.out.println("Nth node from end is - " + nthNodeFromEnd.data);
		
		//insertInSortedList
		//sll.insertInSortedList(15);
		//sll.display();
		
		//deleteNode
		sll.deleteNode(2);
	    sll.display();
	
        
	}

}
