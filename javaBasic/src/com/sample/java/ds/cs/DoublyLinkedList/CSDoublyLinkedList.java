package com.sample.java.ds.cs.DoublyLinkedList;

import java.util.NoSuchElementException;

public class CSDoublyLinkedList {

	private ListNode head;
	private ListNode tail;
	private int length;

	private class ListNode {
		private int data; // Can be any generic type
		private ListNode next;
		private ListNode previous;

		public ListNode(int data) {
			this.data = data;
		}
	}

	public CSDoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	public boolean isEmpty() {
		return length == 0; // or head == null
	}

	public int length() {
		return length;
	}

	public void displayForward() {
		if (head == null) {
			return;
		}

		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public void displayBackward() {
		if (head == null) {
			return;
		}

		ListNode temp = tail;
		while (temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.previous;
		}
		System.out.println("null");
	}

	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}

	public void insertEnd(int value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		length++;
	}

	private boolean isValidIndex(int index) {
		return index >= 0 && index <= length;
	}

	public void insertAtIndex(int value, int index) {
		if (!isValidIndex(index)) {
			throw new IndexOutOfBoundsException("Index " + index + " not valid");
		}
		ListNode newNode = new ListNode(value);
		ListNode current = head;

		if (index == 0) {
			insertFirst(value);
		} else if (index == length) {
			insertEnd(value);
		} else {
			for (int j = 0; j < index; j++) {
				current = current.next;
			}
			newNode.next = current;
			current.previous.next = newNode;
			newNode.previous = current.previous;
			current.previous = newNode;
			length++;
		}
	}

	public ListNode deleteFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		ListNode temp = head;
		if (head == tail) {
			tail = null;
		} else {
			head.next.previous = null;
		}
		head = head.next;
		temp.next = null;
		length--;
		return temp;
	}

	public ListNode deleteLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		ListNode temp = tail;
		if (head == tail) {
			head = null;
		} else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		temp.previous = null;
		length--;
		return temp;
	}

	public ListNode deleteAtIndex(int index) {
		if (!isValidIndex(index + 1)) {
			throw new IndexOutOfBoundsException("Index " + index + " not valid");
		}

		ListNode current = head;
		if (index == 0) {
			return deleteFirst();
		} else if (index == length - 1) {
			return deleteLast();
		} else {
			for (int j = 0; j < index; j++) {
				current = current.next;
			}
			current.previous.next = current.next;
			current.next.previous = current.previous;
			length--;
		}
		return current;
	}
}
