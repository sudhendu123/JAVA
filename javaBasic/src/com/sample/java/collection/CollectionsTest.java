package com.sample.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		List<String> fruits = new ArrayList<String>();
		Collections.addAll(fruits, "Apples", "Oranges", "Banana");
		fruits.forEach(System.out::println);

		Collections.sort(fruits);
		System.out.println("Sorted according to natural ordering:");
		fruits.forEach(System.out::println);

		Collections.sort(fruits, Comparator.reverseOrder());
		System.out.println("Sorted according to reverse of natural ordering:");
		fruits.forEach(System.out::println);
		//gets elements index
		System.out.println(Collections.binarySearch(fruits, "Banana"));
		System.out.println(Collections.binarySearch(fruits, "Grapes"));
		//for type safety
		Collection<String> checkedList = Collections.checkedCollection(fruits, String.class);
		System.out.println("Checked list content: " + checkedList);
		
		System.out.println("max :"+Collections.max(fruits));
		
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, "one", "two", "three", "four","five");
		//the index of each copied element in the destination list will be identical to its index in the source list.
		Collections.copy(list, fruits);
		list.forEach(System.out::println);
		
		// This method returns true if the two specified collections have no elements in common.
		System.out.println("disjoint: "+Collections.disjoint(list, fruits));
		
		//This method replaces all of the elements of the specified list with the specified element.
		Collections.fill(list, "filled with dummy data");
		list.forEach(System.out::println);
		
		ArrayList<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee(2, "Lokesh", "Gupta"));
		employeesList.add(new Employee(1, "Alex", "Gussin"));
		employeesList.add(new Employee(4, "Brian", "Sux"));
		employeesList.add(new Employee(5, "Neon", "Piper"));
		employeesList.add(new Employee(7, "Alex", "Gussin"));
		
		System.out.println("frq= "+Collections.frequency(employeesList, new Employee(1, "Alex", "Gussin")));
		
		
		final List<String> singleElementList =
		         Collections.singletonList("A single String to add.");
		System.out.println(singleElementList);
		
		 List<String>  mylist = new ArrayList<String>();  
         mylist.add("Java");  
         mylist.add("Python");  
         mylist.add("Cobol");  
         mylist.add("Perl");  
         mylist.add("Android");  
         System.out.println("Original List : " + mylist);    
         //Rotate the element by distance 3  
         Collections.rotate(mylist, 3);    
         System.out.println("Rotated List: " + mylist);  
         
         System.out.println("Original List : " +mylist);  
         //Perform swapping  
         Collections.swap(mylist, 0, 2);  
         System.out.println("List after swapping : " +mylist);  
	}
}
