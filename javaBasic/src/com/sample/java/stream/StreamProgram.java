package com.sample.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProgram {

	public static void main(String[] args) {
		// Given a list of integers, find out all the even numbers that exist in the
		// list using Stream functions?
		System.out.println("even====================");
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
		

		// Given a list of integers, find out all the numbers starting with 1 using
		// Stream functions?
		System.out.println("one====================");
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		myList.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);
		

		// How to find duplicate elements in a given integers list in java using Stream
		// functions?
		System.out.println("duplicate====================");
		List<Integer> dup = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet<>();
		dup.stream().filter(n -> !set.add(n)).forEach(System.out::println);
		

		// Given the list of integers, find the first element of the list using Stream
		// functions?
		System.out.println("first====================");
		List<Integer> first = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		first.stream().findFirst().ifPresent(System.out::println);

		// Given a list of integers, find the total number of elements present in the
		// list using Stream functions?
		System.out.println("totalElement====================");
		List<Integer> count = Arrays.asList(10,15,8,49,25,98,98,32,15);
		 long number = count.stream().count();
		 System.out.println(number);
		
		
		//Given a list of integers, find the maximum value element present in it using Stream functions?
		 System.out.println("maxElement====================");
		 List<Integer> max = Arrays.asList(10,15,8,49,25,98,98,32,15);
		 int maxx=max.stream().max(Integer::compare).get();
		 System.out.println(maxx);
		

		// Given a String, find the first non-repeated character in it using Stream functions?
		 System.out.println("nonRepeatable====================");	
		String input = "Java articles are Awesome";
		Character result = input.chars() // Stream of String       
	            .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
	            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
	            .entrySet()
	            .stream()
	            .filter(entry -> entry.getValue() == 1L)
	            .map(entry -> entry.getKey())
	            .findFirst()
	            .get();
	    System.out.println(result); 
	    Character result1 =input.chars().mapToObj(c -> (char) c)
        .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch))
        .findFirst().orElse(null);
	    System.out.println(result1);
	        
	    
	    //Given a String, find the first repeated character in it using Stream functions?
	    System.out.println("repeateable====================");
	    Character result3 = input.chars() // Stream of String       
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
	    System.out.println(result3);    
	    Set<Character> seenCharacters = new HashSet<>();

	    Character result4 =input.chars()
                    .mapToObj(c -> (char) c)
                    .filter(c -> !seenCharacters.add(c))
                    .findFirst()
                    .orElse(null);     
	    System.out.println(result4);    
	    
		
	    //Given a list of integers, sort all the values present in it using Stream functions?
	    System.out.println("sorting====================");
	    List<Integer> sort = Arrays.asList(10,15,8,49,25,98,98,32,15);
	    sort.stream()
        .sorted()
        .forEach(System.out::println);
		
		
		//Given a list of integers, sort all the values present in it in descending order using Stream functions?
	    System.out.println("revSorting====================");
	    List<Integer> sortDesc = Arrays.asList(10,15,8,49,25,98,98,32,15);
		sortDesc.stream()
              .sorted(Collections.reverseOrder())
              .forEach(System.out::println);
		
		
		//Given an integer array nums, return true if any value appears at least twice in the array, 
		//and return false if every element is distinct.
		System.out.println("twiceArray====================");
		int[] nums=new int[] {1,2,3,1};
		Set<Integer> setData = new HashSet<>();
        boolean res=Arrays.stream(nums)
                     .anyMatch(num -> !setData.add(num));
        System.out.println(res);
		
		
		//How will you get the current date and time using Java 8 Date and Time API?
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
        
        //Write a Java 8 program to concatenate two Streams?
        System.out.println("ContactString====================");
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
        concatStream.forEach(str -> System.out.print(str + " "));
        
        //Java 8 program to perform cube on list elements and filter numbers greater than 50.
        System.out.println("==CubeGreater====================");
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        integerList.stream()
                   .map(i -> i*i*i)
                   .filter(i -> i>50)
                   .forEach(System.out::println);

        //Write a Java 8 program to sort an array and then convert the sorted array into Stream?
        System.out.println("==sort array====================");
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(m -> System.out.println(m + " "));
        
        //How to use map to convert object into Uppercase in Java 8?
        System.out.println("uppercase====================");
        List<String> nameList=new ArrayList<String>();
        nameList.add("aa");
        nameList.add("bb");
        nameList.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toList()).forEach(System.out::println);
        
        //How to count each element/word from the String ArrayList in Java8?
        System.out.println("count each element====================");
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesCount = names
                                .stream()
                                .collect(
                                 Collectors.groupingBy(
                                  Function.identity(), Collectors.counting()));
        System.out.println(namesCount);
     
        //How to find only duplicate elements with its count from the String ArrayList in Java8?
        Map<String,Long> namesCounts = names
                                     .stream()
                         .filter(x->Collections.frequency(names, x)>1)
                         .collect(Collectors.groupingBy
                         (Function.identity(), Collectors.counting()));
        System.out.println(namesCounts);
        
        //How to find only duplicate elements with its count from the String ArrayList in Java8?
        List<String> namesDup = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesDupCounts = namesDup
                .stream()
                .filter(x->Collections.frequency(names, x)>1)
                .collect(Collectors.groupingBy
                		(Function.identity(), Collectors.counting()));
        	System.out.println(namesDupCounts);
        	
        //How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
		/*
		 * Optional.ofNullable(noteLst) .orElseGet(Collections::emptyList) // creates
		 * empty immutable list: [] in case noteLst is null
		 * .stream().filter(Objects::nonNull) //loop throgh each object and consider non
		 * null objects .map(note -> Notes::getTagName) // method reference, consider
		 * only tag name .forEach(System.out::println); // it will print tag names
		 */        
        	
        //Write a program to print the count of each character in a String?
        	String s="string data to count each character";
        Map<String, Long> map = Arrays.stream(s.split(""))
                    .map(String::toLowerCase)
                    .collect(Collectors
                    .groupingBy(str -> str, 
                      LinkedHashMap::new, Collectors.counting()));
        System.out.println("map :"+map );
        	
	}

}
