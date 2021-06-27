package com.sample.java.ds.cs.CircularSinglyLinkedList;

import java.util.NoSuchElementException;

public class CSCircularLinkedList {

	private ListNode last;
	private int length;

	private class ListNode {
		private ListNode next;
		private int data;

		public ListNode(int data) {
			this.data = data;
		}
	}

	public CSCircularLinkedList() {
		last = null;
		length = 0;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public void createCircularLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(15);

		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;

		last = fourth;
	}

	public void display() {
		if (last == null) {
			return;
		}

		ListNode first = last.next;
		while (first != last) {
			System.out.print(first.data + " --> ");
			first = first.next;
		}
		System.out.println(first.data);
	}

	public int length() {
		if (last == null) {
			return 0;
		}

		int length = 1; // counting node first
		ListNode first = last.next;
		while (first != last) {
			first = first.next;
			length++;
		}
		return length;
	}

	public void insertLast(int data) {
		ListNode temp = new ListNode(data);
		if (last == null) {
			last = temp;
			last.next = last;
		} else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		length++;
	}

	public void insertFirst(int data) {
		ListNode temp = new ListNode(data);
		if (last == null) {
			last = temp;
		} else {
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}

	public ListNode removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Circular Singly Linked List is already empty");
		}

		ListNode temp = last.next;
		if (last.next == last) {
			last = null;
		} else {
			last.next = temp.next;
		}
		temp.next = null;
		length--;
		return temp;
	}

	public ListNode removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Circular Singly Linked List is already empty");
		}

		ListNode temp = last;
		if (last.next == last) {
			last = null;
		} else {
			ListNode secondLast = last;
			while (secondLast.next != last) {
				secondLast = secondLast.next;
			}
			secondLast.next = last.next;
			last = secondLast;
		}
		temp.next = null;
		length--;
		return temp;
	}
}
