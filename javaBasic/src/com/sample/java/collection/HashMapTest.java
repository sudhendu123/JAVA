package com.sample.java.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		/* This is how to declare HashMap */
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		/* Adding elements to HashMap */
		hmap.put(12, "Chaitanya");
		hmap.put(2, "Rahul");
		hmap.put(7, "Singh");
		hmap.put(49, "Ajeet");
		hmap.put(3, "Anuj");

		/* Display content using Iterator */
		Set<?> set = hmap.entrySet();
		Iterator<?> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}

		for(Entry<Integer, String> ent:hmap.entrySet()) {
			System.out.println("entry set-->"+ent.getValue()+":"+ent.getKey());
		}
		/* Get values based on key */
		String var = hmap.get(2);
		System.out.println("Value at index 2 is: " + var);

		/* Remove values based on key */
		hmap.remove(3);
		System.out.println("Map key and values after removal:");
		Set set2 = hmap.entrySet();
		Iterator iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry mentry2 = (Map.Entry) iterator2.next();
			System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
			System.out.println(mentry2.getValue());
		}

		// FOR LOOP
		System.out.println("For Loop:");
		for (Map.Entry me : hmap.entrySet()) {
			System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
		}

		// Checking Key Existence
	    boolean flag = hmap.containsKey(49);
	    System.out.println("Key 22 exists in HashMap? : " + flag);
	    
	 // Checking Value Existence
	    boolean flag1 = hmap.containsValue("Rahul");
	    System.out.println("String Singh exists in HashMap? : " + flag1);
	}
}
