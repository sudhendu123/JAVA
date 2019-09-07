package com.prac.java.util.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueComparable {

	public static void main(String[] args) {
		Queue<Book> q = new PriorityQueue<Book>();
		// Creating Books
		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		// Adding Books to the queue
		q.add(b1);
		q.add(b2);
		q.add(b3);
		System.out.println("Traversing the queue elements:");
		System.out.println(q.poll());
		System.out.println(q);

	}

}

class Book implements Comparable<Book> {
	int id;
	String name, author, publisher;
	int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int compareTo(Book b) {
		if (id > b.id) {
			return 1;
		} else if (id < b.id) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", quantity="
				+ quantity + "]";
	}
	
}
