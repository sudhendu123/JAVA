package com.sample.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

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
		System.out.println("ArrayList items copy: " + intlist);

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
		// iterate over empty string
		ArrayList<String> obj1 = new ArrayList<>();
		for (String s : obj1) {
			System.out.println("empty");
		}
		System.out.println("didn't enter");
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

		ArrayList<empl> empList = new ArrayList<>();
		empList.add(new empl(1, "abc", 24, "10000"));
		empList.add(new empl(2, "abc2", 22, "20000"));
		empList.add(new empl(3, "abc3", 23, "30000"));
		empList.add(new empl(4, "abc2", 24, "4000"));
		empList.add(new empl(5, "abc2", 24, "4000"));
		empList.add(new empl(6, "abc6", 24, "4000"));
		empList.add(new empl(1, "abc", 24, "10000"));

		// empty list removing element
		ArrayList<empl> empList1 = new ArrayList<>();
		List<Integer> emptyEmp = empList1.stream().map(empl::getId).collect(Collectors.toList());
		List<Integer> emptyEmp1 = empList1.stream().map(empl::getId).collect(Collectors.toList());
		emptyEmp1.removeAll(emptyEmp);
		System.out.println("emptyEmp " + emptyEmp);
		// getting only ages
		List<Integer> idslistOne = empList.stream().map(empl::getId).collect(Collectors.toList());

		// Compare two arraylists for equality
		List<Integer> idslistTwo = empList.stream().map(empl::getId).collect(Collectors.toList());
		// idslistTwo.remove(1);
		Collections.sort(idslistOne);
		Collections.sort(idslistTwo);
		boolean isEqual = idslistTwo.equals(idslistOne); // false
		System.out.println("list equality: " + isEqual);

		// find common elements
		idslistOne.retainAll(idslistTwo);
		System.out.println("equal elements: " + idslistOne);

		// find additional elements
		// remove all elements of second list
		// find missing elements
		idslistOne.removeAll(idslistTwo);
		System.out.println("uequal elements: " + idslistOne);

		List<empl> objUniqueName = empList.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(empl::getName)))).stream()
				.collect(Collectors.toList());
		System.out.println("objUniqueName :" + objUniqueName);
		List<empl> objUniqueAge = empList.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(empl::getAge)))).stream()
				.collect(Collectors.toList());
		System.out.println("objUniqueAge :" + objUniqueAge);
		// distinct() if impl hashCode and equals
		List<empl> uniqueList = empList.stream().distinct().collect(Collectors.toList());
		System.out.println("uniqueList :" + uniqueList);

		List<empl> distinctEmp = empList.stream()
				.collect(Collectors.collectingAndThen(Collectors.toMap(c -> Arrays.asList(c.getName(), c.getAge()),
						Function.identity(), (a, b) -> a, LinkedHashMap::new), m -> new ArrayList<>(m.values())));
		System.out.println("distinctEmp :" + distinctEmp);

		Collection<empl> nonDuplicatedEmployeesById = empList.stream()
				.<Map<Integer, empl>>collect(HashMap::new, (m, e) -> m.put(e.getId(), e), Map::putAll).values();

		System.out.println("nonDuplicatedEmployeesById :" + nonDuplicatedEmployeesById);

		Collection<empl> nonDuplicatedEmployeesByName = empList.stream()
				.<Map<String, empl>>collect(HashMap::new, (m, e) -> m.put(e.getName(), e), Map::putAll).values();

		System.out.println("nonDuplicatedEmployeesByName :" + nonDuplicatedEmployeesByName);

		// unique by id n age
		Object uniqueIdNAge = empList.stream()
				.collect(Collectors.collectingAndThen(
						Collectors.toMap(x -> Arrays.asList(x.getId(), x.getAge()), x -> x,
								BinaryOperator.minBy(Comparator.comparing(empl::getId))),
						map -> new ArrayList<>(map.values())));
		System.out.println("uniqueIdNAge :" + uniqueIdNAge);

		// splitting list to chunks
		final List<String> listTest = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
				"N", "O", "P", "X");

		final AtomicInteger counter = new AtomicInteger(0);
		final int size = 5;

		final Collection<List<String>> partitioned = listTest.stream()
				.collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size)).values();

		// partitioned.forEach(System.out::println);
		for (List<String> par : partitioned) {
			System.out.println("partitioned " + par);
		}

		// getting element by field
		empl elementByName = empList.stream().filter(e -> e.getName().equals("abc")).findAny().orElse(null);
		System.out.println("elementByName :" + elementByName);

		List<String> cities1 = Arrays.asList("Milan", "London", "New York", "San Francisco");
		String citiesCommaSeparated = String.join(",", cities1);
		System.out.println("citiesCommaSeparated " + citiesCommaSeparated);
		String citiesCommaSeparated1 = cities.stream().collect(Collectors.joining(","));
		System.out.println("citiesCommaSeparated " + citiesCommaSeparated1);

	}

}
