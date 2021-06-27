package com.sample.java.ds.cs.SinglyLinkedList;

public class CSSinglyLinkedList<E> {

	public ListNode<E> head;
	public ListNode<E> tail;    

	public static class ListNode<E> {
		E data; // Can be a generic type
		public ListNode<E> next; // Reference to next ListNode<E> in list

		public ListNode(E data) {
			this.data = data;
			this.next = null;
		}
	}

	public void display() {
		// head
		// 10 --> 1 --> 8 --> 11 --> null
		// current(current = head)
		// current(current.next)
		ListNode<E> current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public int length() {
		if (head == null) {
			return 0;
		}
		int count = 0;
		ListNode<E> current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void insertFirst(E value) {
		ListNode<E> newNode = new ListNode<E>(value);
		newNode.next = head;
		head = newNode;
	}

	public void insertLast(E value) {
		ListNode<E> newNode = new ListNode<E>(value);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode<E> current = head;
		while (null != current.next) {
			current = current.next;
		}
		current.next = newNode;
	}

	public void insertAtPosition(E data, int position) {
		ListNode<E> newNode = new ListNode<E>(data);
		if (position == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode<E> previous = head;
			int count = 0;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}

			ListNode<E> current = previous.next;
			newNode.next = current;
			previous.next = newNode;
		}
	}

	public ListNode<E> deleteFirst() {
		if (head == null) {
			return null;
		}
		ListNode<E> temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}

	public ListNode<E> deleteLast() {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<E> current = head;
		ListNode<E> previous = null;

		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null; // break the chain
		return current;
	}

	public void deleteAtPosition(int position) {
		if (position == 0) {
			ListNode<E> temp = head;
			head = head.next;
			temp.next = null;
		} else {
			ListNode<E> previous = head;
			int count = 0;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}

			ListNode<E> current = previous.next;
			previous.next = current.next;
			current.next = null;
		}
	}

	public boolean searchElement(E searchKey) {
		if (head == null) {
			return false;
		}

		ListNode<E> current = head;
		while (current != null) {
			if (current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public ListNode<E> reverse() {
		if (head == null) {
			return head;
		}

		ListNode<E> current = head;
		ListNode<E> previous = null;
		ListNode<E> next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public ListNode<E> getMiddleNode() {
		if (head == null) {
			return null;
		}
		ListNode<E> slowPtr = head;
		ListNode<E> fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	public ListNode<E> getNthNodeFromEnd(int n) {
		if (head == null) {
			return null;
		}

		if (n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}

		ListNode<E> mainPtr = head;
		ListNode<E> refPtr = head;

		int count = 0;

		while (count < n) {
			if (refPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPtr = refPtr.next;
			count++;
		}

		while (refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}

	/**
	public ListNode<E> insertInSortedList(E value) {
		ListNode<E> newNode = new ListNode(value);

		if (head == null) {
			return newNode;
		}

		ListNode<E> current = head;
		ListNode<E> temp = null;

		while (current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}

		newNode.next = current;
		temp.next = newNode;
		return head;
	}
	*/

	public void deleteNode(E key) {
		ListNode<E> current = head;
		ListNode<E> temp = null;

		if (current != null && current.data == key) {
			head = current.next;
			return;
		}

		while (current != null && current.data != key) {
			temp = current;
			current = current.next;
		}

		if (current == null) {
			return;
		}

		temp.next = current.next;
	}
	
	public void addNode(E data) {    
        //Create a new node    
		ListNode<E> newNode = new ListNode<E>(data);    
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;    
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
    }    
}
