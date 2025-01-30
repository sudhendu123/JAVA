package com.sample.java.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * This package consists of classes, interfaces and enum to allows functional-style operations on the elements.
 *  We can use stream by importing java.util.stream package.
 *
 */

public class StreamApiTest {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		List<Float> productPriceList2 = productsList.stream().filter(p -> p.price > 30000)// filtering data
				.map(p -> p.price) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList2);
		// iterator
		productsList.stream().filter(product -> product.price == 30000)
				.forEach(product -> System.out.println(product.name));
		productsList.stream().forEach(n->{
			System.out.println(n.name);	
			});
		// reduce
		Float totalPrice = productsList.stream().map(product -> product.price).reduce(0.0f,
				(sum, price) -> sum + price); // accumulating price
		System.out.println(totalPrice);

		// Using Collectors's method to sum the prices.
		double totalPrice3 = productsList.stream().collect(Collectors.summingDouble(product -> product.price));
		System.out.println(totalPrice3);

		List<Product> result = productsList.stream().filter(s->s.name.startsWith("H")).collect(Collectors.toList());
		System.out.println(result);
		
		//sorted have to implement comparable
		List<Product> sortResult = productsList.stream().sorted().collect(Collectors.toList());
		System.out.println("sortResult:"+sortResult);
		// max() method to get max Product price
		Product productA = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1)
				.get();
		System.out.println(productA.price);
		// min() method to get min Product price
		Product productB = productsList.stream().max((product1, product2) -> product1.price < product2.price ? 1 : -1)
				.get();
		System.out.println(productB.price);

		// count number of products based on the filter
		long count = productsList.stream().filter(product -> product.price < 30000).count();
		System.out.println(count);

		// Converting product List into Set
		Set<Float> productPriceList = productsList.stream().filter(product -> product.price < 30000)
				.map(product -> product.price).collect(Collectors.toSet());
		System.out.println(productPriceList);

		// Converting Product List into a Map
		Map<Integer, String> productPriceMap = productsList.stream().collect(Collectors.toMap(p -> p.id, p -> p.name));
		System.out.println(productPriceMap);

		List<Float> productPriceList1 = productsList.stream().filter(p -> p.price > 30000) // filtering data
				.map(Product::getPrice) // fetching price by referring getPrice method
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList1);
		
		//removing duplicate object in list of object
		Set<Integer> nameSet = new HashSet<>();
		List<Product> ProductDist = productsList.stream()
		            .filter(e -> nameSet.add(e.getId()))
		            .collect(Collectors.toList());
		System.out.println("ProductDist :"+ProductDist);
		
		List<Product> ProductDist1 = productsList.stream().distinct().map(reqDto -> new Product(reqDto.getId(), reqDto.getPrice()))
                .collect(Collectors.toList());
		System.out.println("ProductDist1 "+ProductDist1);
		
		Collection<Product> nonDuplicatedElements = productsList.stream()
				   .<Map<Integer, Product>> collect(HashMap::new,(m,e)->m.put(e.getId(), e), Map::putAll)
				   .values();
		
		System.out.println("nonDuplicatedElements :"+nonDuplicatedElements);
	}
}

class Product implements Comparable<Product>{
	int id;
	String name;
	float price;

	public Product(int id,  float price) {
		this.id = id;
		this.price = price;
	}
	
	
	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public float getPrice() {  
        return price;  
    }
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o) {
		if(id==o.id)  
			return 0;  
			else if(id<o.id)  
			return 1;  
			else  
			return -1; 
	}  
	
	
}