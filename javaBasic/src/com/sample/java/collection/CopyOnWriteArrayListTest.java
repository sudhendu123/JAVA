package com.sample.java.collection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

//CopyOnWriteArrayList is a thread-safe variant of ArrayList where operations which can change the ArrayList (add, update, set methods) creates a clone of the underlying array.
//CopyOnWriteArrayList is to be used in a Thread based environment where read operations are very frequent and update operations are rare.
public class CopyOnWriteArrayListTest {
	public static void main(String args[]) {
		// create an array list
		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<>();
		System.out.println("Initial size of al: " + al.size());

		// add elements to the array list
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		al.add(1, "A2");
		System.out.println("Size of al after additions: " + al.size());

		// display the array list
		System.out.println("Contents of al: " + al);

		// Remove elements from the array list
		al.remove("F");
		al.remove(2);
		System.out.println("Size of al after deletions: " + al.size());
		System.out.println("Contents of al: " + al);

		try {
			Iterator<String> iterator = al.iterator();
			while (iterator.hasNext()) {
				iterator.remove();
			}
		} catch (UnsupportedOperationException e) {
			System.out.println("Method not supported:");
		}
		System.out.println("Size of al: " + al.size());
	}

}
