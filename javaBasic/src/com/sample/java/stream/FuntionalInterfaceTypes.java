package com.sample.java.stream;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 
 * A functional interface in Java is an interface that contains exactly one
 * abstract method. These interfaces can be implemented using lambda
 * expressions, method references, or anonymous classes. Here are some common
 * types of functional interfaces with examples: 
 * 
 1.Function<T, R>: Takes one  argument and produces a result. 
 2.BiFunction<T, U, R>: Takes two arguments and produces a result.
 3.Consumer<T>: Takes one argument and returns no result.
 4.Supplier<T>: Takes no arguments and produces a result.
 5.Predicate<T>: Takes one argument and returns a boolean.
 *
 */
public class FuntionalInterfaceTypes {

	public static void main(String[] args) {
		// Function<T, R>
		Function<String, Integer> stringLength = String::length;
		System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));

		// BiFunction<T, U, R>
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println("Sum of 10 and 20: " + add.apply(10, 20));

		// Consumer<T>
		Consumer<String> print = System.out::println;
		print.accept("Hello, World!");

		// Supplier<T>
		Supplier<Double> randomValue = Math::random;
		System.out.println("Random value: " + randomValue.get());

		// Predicate<T>
		Predicate<Integer> isEven = n -> n % 2 == 0;
		System.out.println("Is 4 even? " + isEven.test(4));
	}
}
