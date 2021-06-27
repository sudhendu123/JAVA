package com.prac.java.util.concurency;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {
	public static void main(String[] args) {
		ConcurrentNavigableMap<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<String, String>();
		concurrentSkipListMap.put("3", "Apple");
		concurrentSkipListMap.put("2", "Ball");
		concurrentSkipListMap.put("1", "Car");
		concurrentSkipListMap.put("5", "Doll");
		concurrentSkipListMap.put("4", "Elephant");

		System.out.println("ceilingEntry-2: " + concurrentSkipListMap.ceilingEntry("2"));
		NavigableSet<String> navigableSet = concurrentSkipListMap.descendingKeySet();
		System.out.println("descendingKeySet: ");
		Iterator<String> itr = navigableSet.iterator();
		while (itr.hasNext()) {
			String s = (String) itr.next();
			System.out.println("itr :" + s);
		}
		for (Entry<String, String> amp : concurrentSkipListMap.entrySet()) {
			System.out.println("map val " + amp);
		}
		System.out.println("firstEntry: " + concurrentSkipListMap.firstEntry());
		System.out.println("lastEntry: " + concurrentSkipListMap.lastEntry());
		System.out.println("pollFirstEntry: " + concurrentSkipListMap.pollFirstEntry());
		System.out.println("now firstEntry: " + concurrentSkipListMap.firstEntry());
		System.out.println("pollLastEntry: " + concurrentSkipListMap.pollLastEntry());
		System.out.println("now lastEntry: " + concurrentSkipListMap.lastEntry());
	}

}