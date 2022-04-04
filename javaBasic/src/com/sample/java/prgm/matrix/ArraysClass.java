package com.sample.java.prgm.matrix;

import java.util.Arrays;

public class ArraysClass {
	public static void main(String[] args) {

		// Get the Array
		int intArr[] = { 10, 20, 15, 22, 35 };
		// Get the second Array
		int intArr1[] = { 10, 15, 22 };

		// To convert the elements as List
		System.out.println("Integer Array as List: " + Arrays.asList(intArr));

		// -------------------binary search----------------
		Arrays.sort(intArr);

		int intKey = 22;

		// Print the key and corresponding index
		System.out.println(intKey + " found at index = " + Arrays.binarySearch(intArr, intKey));

		System.out.println(intKey + " found at index = " + Arrays.binarySearch(intArr, 1, 3, intKey));

		// -------------------compare----------------
		// To compare both arrays
		System.out.println("Integer Arrays on comparison: " + Arrays.compare(intArr, intArr1));

		// To compare both arrays
		System.out.println("Integer Arrays on comparison: " + Arrays.compareUnsigned(intArr, intArr1));

		// Get the Arrays
		int intDoubArr[][] = { { 10, 20, 15, 22, 35 } };

		// Get the second Arrays
		int intDoubArr1[][] = { { 10, 15, 22 } };

		// To compare both arrays
		System.out.println("Integer Arrays on comparison: " + Arrays.deepEquals(intDoubArr, intDoubArr1));
		// -------------------Array copy----------------
		// To print the elements in one line
		System.out.println("Integer Array: " + Arrays.toString(intArr));

		System.out.println("\nNew Arrays by copyOf:\n");

		System.out.println("Integer Array: " + Arrays.toString(Arrays.copyOf(intArr, 10)));

		// To copy the array into an array of new length
		System.out.println("Integer Array: " + Arrays.toString(Arrays.copyOfRange(intArr, 1, 3)));

		// To get the dep hashCode of the arrays
		System.out.println("Integer Array: " + Arrays.deepHashCode(intDoubArr));

		// To get the deep String of the arrays
		System.out.println("Integer Array: " + Arrays.deepToString(intDoubArr));

		// To compare both arrays
		System.out.println("Integer Arrays on comparison: " + Arrays.equals(intArr, intArr1));

		// To get the hashCode of the arrays
		System.out.println("Integer Array: " + Arrays.hashCode(intArr));

		// To compare both arrays
		System.out.println("The element mismatched at index: " + Arrays.mismatch(intArr, intArr1));

		// To sort the array using parallelSort
		Arrays.parallelSort(intArr);

		System.out.println("Integer Array: " + Arrays.toString(intArr));

		// To sort the array using normal sort-
		Arrays.sort(intArr);

		System.out.println("Integer Array: " + Arrays.toString(intArr));

		// To sort the array using normal sort
		Arrays.sort(intArr, 1, 3);

		System.out.println("Integer Array: " + Arrays.toString(intArr));

	}

}
