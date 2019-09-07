package com.sample.java.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.stream.Stream;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();

		// Adding elements to the LinkedList
		list.add("Element1");
		list.add("Element2");
		list.add("Element3");
		list.add("Element4");

		System.out.println("descendingIterator");
		Iterator<String> it = list.descendingIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("ListIterator Next");
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		System.out.println("ListIterator previous");
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}

		Spliterator<String> splitIt = list.spliterator();

		// estimateSize method
		System.out.println("estimate size : " + splitIt.estimateSize());

		// getExactSizeIfKnown method
		System.out.println("exact size : " + splitIt.getExactSizeIfKnown());

		// hasCharacteristics and characteristics method
		System.out.println(splitIt.hasCharacteristics(splitIt.characteristics()));

		System.out.println("Content of arraylist :");
		// forEachRemaining method
		splitIt.forEachRemaining((n) -> System.out.println(n));

		// Obtaining another Stream to the array list.
		Stream<String> str1 = list.stream();
		Spliterator<String> splitr1 = str1.spliterator();

		// trySplit() method
		Spliterator<String> splitr2 = splitr1.trySplit();

		if (splitr1 != null) {
			System.out.println("Output from splitr1: ");
			splitr1.forEachRemaining(System.out::println);
		}
		
		// If splitr1 could be split, use splitr2 first.
		if (splitr2 != null) {
			System.out.println("Output from splitr2: ");
			splitr2.forEachRemaining((n) -> System.out.println(n));
		}
		
		LinkedList list2 = (LinkedList)list.clone();
		 
	     // Displaying elements of second LinkedList
	     System.out.println("List 2 Elements: "+list2);
		
	}

}
