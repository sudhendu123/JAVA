package com.sample.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("def");
		list.add("ghi");
		list.add(1, "sdf");

		list.remove(1);
		list.remove("abc");

		list.set(1, "replaced");

		System.out.println(list.get(1));
		System.out.println(list.indexOf("abcs"));
		System.out.println(list.size());
		System.out.println(list.contains("def"));
		list.clear();
		System.out.println("empty list: " + list);
		list.add("qwe");
		// initialization
		ArrayList<Integer> intlist = new ArrayList<Integer>(Collections.nCopies(10, 5));
		System.out.println("ArrayList items: " + intlist);

		ArrayList<String> cities = new ArrayList<>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("Delhi");
				add("Agra");
				add("Chennai");
			}
		};
		System.out.println("Content of Array list cities:" + cities);

		ArrayList<String> obj = new ArrayList<String>(Arrays.asList("Pratap", "Peter", "Harsh"));
		System.out.println("Elements are:" + obj);
		// adding or merging list
		obj.addAll(cities);
		System.out.println("added cities to name" + obj);
		obj.addAll(2, list);
		System.out.println("added list at index" + obj);
		obj.add(1, "Delhi");
		System.out.println(obj + "last index of Delhi :" + obj.lastIndexOf("Delhi"));

		List<String> syncal = Collections.synchronizedList(obj);
		System.out.println("synchronized colection" + syncal);

		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();

		Collections.swap(obj, 1, 4);
		System.out.println("after swap" + obj);
		ArrayList<String> al2 = (ArrayList<String>) obj.clone();
		System.out.println("Shallow copy of ArrayList: " + al2);
		obj.trimToSize();
		// Increase capacity to 5
		obj.ensureCapacity(5);
		/* ArrayList to Array Conversion */
		String objj[] = obj.toArray(new String[obj.size()]);
		// sublisting
		List<String> subsList = obj.subList(1, 4);
		System.out.println("sub list" + subsList);
		// loop ArrayList
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(14);
		arrlist.add(7);
		arrlist.add(39);
		arrlist.add(40);

		/* ArrayList to Array Conversion */
		String stringArray[] = obj.toArray(new String[obj.size()]);
		List<String> arraysAslIst = Arrays.asList(stringArray);
		/* For Loop for iterating ArrayList */
		System.out.println("For Loop");
		for (int counter = 0; counter < arrlist.size(); counter++) {
			System.out.println(arrlist.get(counter));
		}

		/* Advanced For Loop */
		System.out.println("Advanced For Loop");
		for (Integer num : arrlist) {
			System.out.println(num);
		}

		/* While Loop for iterating ArrayList */
		System.out.println("While Loop");
		int count = 0;
		while (arrlist.size() > count) {
			System.out.println(arrlist.get(count));
			count++;
		}

		/* Looping Array List using Iterator */
		System.out.println("Iterator");
		Iterator<Integer> iter = arrlist.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		// enumeration
		System.out.println("enumerate");
		Enumeration<Integer> enumerat = Collections.enumeration(arrlist);
		while (enumerat.hasMoreElements()) {
			System.out.println(enumerat.nextElement());
		}
	}

}
