package com.sample.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {

	
	public static void main(String[] args) {
		
		 List < Integer > nums = Arrays.asList(1, 3, 6, 8, 10, 18, 36);
		    System.out.println("List of numbers: " + nums);

		    // Calculate the average using streams
		    double average = nums.stream()
		      .mapToDouble(Integer::doubleValue)
		      .average()
		      .orElse(0.0);

		    System.out.println("Average value of the said numbers: " + average);
		    
		    List < String > colors = Arrays.asList("RED", "grEEn", "white", "Orange", "pink");
		    System.out.println("List of strings: " + colors);
		    // Convert strings to uppercase using streams
		    List < String > uppercaseStrings = colors.stream()
		      .map(String::toUpperCase)
		      .collect(Collectors.toList());

		    System.out.println("\nUppercase Strings: " + uppercaseStrings);

		    // Convert strings to lowercase using streams
		    List < String > lowercaseStrings = colors.stream()
		      .map(String::toLowerCase)
		      .collect(Collectors.toList());

		    System.out.println("Lowercase Strings: " + lowercaseStrings);
		    
		    List < Integer > numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		    // Sum of even numbers
		    int sumOfEvens = numbers.stream()
		      .filter(num -> num % 2 == 0)
		      .mapToInt(Integer::intValue)
		      .sum();

		    System.out.println("Sum of even numbers: " + sumOfEvens);

		    // Sum of odd numbers
		    int sumOfOdds = numbers.stream()
		      .filter(num -> num % 2 != 0)
		      .mapToInt(Integer::intValue)
		      .sum();

		    System.out.println("Sum of odd numbers: " + sumOfOdds);
		    
		    List < Integer > nums1 = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);
		    System.out.println("Original List of numbers: " + nums1);
		    // Remove duplicates
		    List < Integer > distinctNumbers = nums1.stream()
		      .distinct()
		      .collect(Collectors.toList());
		    System.out.println("After removing duplicates from the said list: " + distinctNumbers);
		    
		    List < String > colors1 = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
		    System.out.println("Original list of strings (colors): " + colors1);
		    char startingLetter = 'B';
		    // Count strings starting with a specific letter
		    long ctr = colors1.stream()
		      .filter(s -> s.startsWith(String.valueOf(startingLetter)))
		      .count();
		    System.out.println("\nNumber of colors starting with '" + startingLetter + "': " + ctr);
		    char startingLetter1 = 'Y';
		    // Count strings starting with a specific letter
		    ctr = colors1.stream()
		      .filter(s -> s.startsWith(String.valueOf(startingLetter1)))
		      .count();
		    System.out.println("\nNumber of colors starting with '" + startingLetter1 + "': " + ctr);
		    
		    List < String > colors2 = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
		    System.out.println("Original List of strings(colors): " + colors2);
		    // Sort strings in ascending order
		    List < String > ascendingOrder = colors2.stream()
		      .sorted()
		      .collect(Collectors.toList());

		    // Sort strings in descending order
		    List < String > descendingOrder = colors2.stream()
		      .sorted(Comparator.reverseOrder())
		      .collect(Collectors.toList());

		    System.out.println("\nSorted in Ascending Order: " + ascendingOrder);
		    System.out.println("\nSorted in Descending Order: " + descendingOrder);
		    
		    List < Integer > nums3 = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
		    System.out.println("Original list of numbers: " + nums3);
		    // Find the maximum value
		    Integer max_val = nums3.stream()
		      .max(Integer::compare)
		      .orElse(null);

		    // Find the minimum value
		    Integer min_val = nums3.stream()
		      .min(Integer::compare)
		      .orElse(null);

		    System.out.println("\nMaximum value of the said list: " + max_val);
		    System.out.println("\nMinimum value of the said list: " + min_val);
		    
		    List < Integer > nums4 = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
		    System.out.println("List of numbers: " + nums4);
		    // Find the second smallest element
		    Integer secondSmallest = nums4.stream()
		      .distinct()
		      .sorted()
		      .skip(1)
		      .findFirst()
		      .orElse(null);

		    // Find the second largest element
		    Integer secondLargest = nums4.stream()
		      .distinct()
		      .sorted((a, b) -> Integer.compare(b, a))
		      .skip(1)
		      .findFirst()
		      .orElse(null);

		    System.out.println("\nSecond smallest element: " + secondSmallest);
		    System.out.println("\nSecond largest element: " + secondLargest);
	}
}
