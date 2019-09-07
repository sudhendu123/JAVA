package com.sample.java.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionExample {
	public static void main(String[] args) {
		int width = 10;

		Drawable d2 = () -> {
			System.out.println("Drawing " + width);
		};
		d2.draw();

		Sayable s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.say());

		// Lambda expression with single parameter.
		SingleParam s1 = (name) -> {
			return "Hello, " + name;
		};
		System.out.println(s1.SingleParamMethod("Sonoo"));

		// You can omit function parentheses
		SingleParam s2 = name -> {
			;
			return "Hello, " + name;
		};
		System.out.println(s2.SingleParamMethod("Sonoo"));

		// Lambda expression without return keyword.
		Addable ad1 = (a, b) -> (a + b);
		System.out.println(ad1.add(10, 20));

		// Lambda expression with return keyword.
		Addable ad2 = (int a, int b) -> {
			return (a + b);
		};
		System.out.println(ad2.add(100, 200));

		// You can pass multiple statements in lambda expression
		SingleParam person = (message) -> {
			String str1 = "I would like to say, ";
			String str2 = str1 + message;
			return str2;
		};
		System.out.println(person.SingleParamMethod("time is precious."));

		// Thread Example without lambda
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("Thread1 is running...");
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		// Thread Example with lambda
		Runnable r2 = () -> {
			System.out.println("Thread2 is running...");
		};
		Thread t2 = new Thread(r2);
		t2.start();

		// Adding Products
		List<Product> list = new ArrayList<Product>();

		list.add(new Product(1, "HP Laptop", 25000f));
		list.add(new Product(3, "Keyboard", 300f));
		list.add(new Product(2, "Dell Mouse", 150f));

		System.out.println("Sorting on the basis of name...");

		// implementing lambda expression
		Collections.sort(list, (p1, p2) -> {
			return p1.name.compareTo(p2.name);
		});
		for (Product p : list) {
			System.out.println(p.id + " " + p.name + " " + p.price);
		}
	}
}

@FunctionalInterface
interface Drawable {
	public void draw();

}

//No Parameter
interface Sayable {
	public String say();
}

//Single Parameter
@FunctionalInterface
interface SingleParam {
	public String SingleParamMethod(String name);
}

//Multiple Parameters
@FunctionalInterface
interface Addable {
	int add(int a, int b);
}
