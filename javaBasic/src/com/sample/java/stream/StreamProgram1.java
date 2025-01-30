package com.sample.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProgram1 {
	public static void main(String[] args) {
		StreamProgram1 pg=new StreamProgram1();

		// Find the longest string in a list of strings using Java streams:
		List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");
		Optional<String> longestString = strings.stream().max(Comparator.comparingInt(String::length));
		System.out.println("longestString :"+longestString);
		
		//Calculate the average age of a list of Person objects using Java streams:
		List<Person> persons = Arrays.asList(
			    new Person("Alice", 25),
			    new Person("Bob", 30),
			    new Person("Charlie", 35)
			);
		double averageAge = persons.stream()
			                          .mapToInt(Person::getAge)
			                          .average()
			                          .orElse(0);
		System.out.println("averageAge"+averageAge);
		
		//Check if a list of integers contains a prime number using Java streams
		List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
		  boolean containsPrime = numbers.stream()
		                                 .anyMatch(pg::isPrime);
		  System.out.println("List contains a prime number: " + containsPrime);
		
		  //Merge two sorted lists into a single sorted list using Java streams:
		  System.out.println("Merge two sorted lists");
		  List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
		  List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
		  Stream.concat(list1.stream(), list2.stream())
		                                  .sorted()
		                                  .collect(Collectors.toList()).forEach(System.out::println);
		  //Find the intersection of two lists using Java streams:
		  System.out.println("intersection of two lists");
		  List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
		  List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);
		  list3.stream().filter(list4::contains)
		  .collect(Collectors.toList()).forEach(System.out::println);
		  
		  //Remove duplicates from a list while preserving the order using Java streams:
		  System.out.println("Remove duplicates from a list");
		  List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
		  numbersWithDuplicates.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
		  
		  //Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
		  List<Transaction> transactions = Arrays.asList(
				    new Transaction("2022-01-01", 100),
				    new Transaction("2022-01-01", 200),
				    new Transaction("2022-01-02", 300),
				    new Transaction("2022-01-02", 400),
				    new Transaction("2022-01-03", 500)
				);

				Map<String, Integer> sumByDay = transactions
				                        .stream()
				                        .collect(Collectors.groupingBy(Transaction::getDate,
				                               Collectors.summingInt(Transaction::getAmount)));
				System.out.println("sumByDay"+sumByDay);
				
			//Find the kth smallest element in an array using Java streams:
				int[] array = {4, 2, 7, 1, 5, 3, 6};
				int k = 3; // Find the 3rd smallest element
				int kthSmallest = Arrays.stream(array)
				                       .sorted()
				                       .skip(k - 1)
				                       .findFirst()
				                       .orElse(-1);
				System.out.println("kthSmallest"+kthSmallest);
				
			//Given a list of strings, find the frequency of each word using Java streams:
			List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
				Map<String, Long> wordFrequency = words.stream()
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				System.out.println("wordFrequency:"+wordFrequency);
				
			//Implement a method to partition a list into two groups based on a predicate using Java streams:
			List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
			Map<Boolean, List<Integer>> partitioned = numbers1
				                        .stream()
				                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
			List<Integer> evenNumbers = partitioned.get(true);
			List<Integer> oddNumbers = partitioned.get(false);
			System.out.println("Even numbers: " + evenNumbers);
			System.out.println("Odd numbers: " + oddNumbers);  
		  
		
	}
	
	public boolean isPrime(int number) {
		  if (number <= 1) {
		    return false;
		  }
		  for (int i = 2; i <= Math.sqrt(number); i++) {
		    if (number % i == 0) {
		        return false;
		    }
		  }
		  return true;
		}

}

class Person{
	String name;
	int age;
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

class Transaction{
	String date;
	int amount;
	public Transaction(String date, int amount) {
		this.date=date;
		this.amount=amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [date=" + date + ", amount=" + amount + "]";
	}
}
