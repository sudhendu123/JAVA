package com.sample.java.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SteamsApiTest1 {
	public static void main(String[] args) {

		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		long totalPrice3 = productsList.stream().filter(p -> p.id > 2).count();
		System.out.println(totalPrice3);

		List<Product> condition = productsList.stream().filter(p -> {
			if (p.id > 3 || p.price > 28000f) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		System.out.println(condition);
		// Convert to steam If 'findAny' then return found If not found, return null
		Product condition1 = productsList.stream().filter(p -> {
			if (p.id > 3 || p.price > 28000f) {
				return true;
			}
			return false;
		}).findAny().orElse(null);
		System.out.println(condition1);

		Product condition2 = (Product) productsList.stream().filter(p -> {
			try {
				if (p.id > 3 || p.price > 28000f) {
					return true;
				}
			} catch (Exception e) {
				// handle exception
			}
			return false;
		}).findAny().orElse(null);
		System.out.println(condition2);

		Map<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(11, "Apple");
		hmap.put(22, "Orange");
		hmap.put(33, "Kiwi");
		hmap.put(44, "Banana");
		hmap.put(1, "ABC");

		// Filter Map by Keys
		Map<Integer, String> filterMapByKeys = hmap.entrySet().stream().filter(map -> map.getKey().intValue() <= 22)
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

		System.out.println("filterMapByKeys: " + filterMapByKeys);
		// Filter Map by Values
		Map<Integer, String> filterMapByValue = hmap.entrySet().stream().filter(map -> "Orange".equals(map.getValue()))
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

		System.out.println("filterMapByValue: " + filterMapByValue);
		//Filter Map by both Keys and Values
		 Map<Integer, String> filterbyKeyValue = hmap.entrySet()
		         .stream()
		         .filter(p -> p.getKey().intValue() <= 2) //filter by key
		         //.limit(2)
		         //.skip(1)
		         .filter(map -> map.getValue().startsWith("A")) //filter by value
		         .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

		     System.out.println("filterbyKeyValue: " + filterbyKeyValue);
	}

}
