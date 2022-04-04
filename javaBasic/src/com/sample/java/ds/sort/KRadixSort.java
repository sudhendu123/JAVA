package com.sample.java.ds.sort;

import java.util.Arrays;
//suppose the max element is of 2 digit , so 3 phases it will run 
//1st phase 1s elements get the last number (number/1)%10
//2nd phase 10s elements get the mid element (number/10)%10
//3rd phase 100s elements get the first element (number/100)%10
public class KRadixSort {
	
	public static void main(String[] args) {
		 int[] numbers = { 387, 468, 134, 123, 68, 221, 769, 37, 7 };
		 KRadixSort.sort(numbers);
	}

	public static void sort(int numbers[]) {
		int maximumNumber = findMaximumNumberIn(numbers);

		int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);

		int placeValue = 1;

		while (numberOfDigits-- > 0) {
			applyCountingSortOn(numbers, placeValue);
			placeValue *= 10;
		}
	}

	private static void applyCountingSortOn(int[] numbers, int placeValue) {
		int range = 10; // radix or the base

		int length = numbers.length;
		int[] frequency = new int[range];
		int[] sortedValues = new int[length];

		for (int i = 0; i < length; i++) {
			int digit = (numbers[i] / placeValue) % range;
			frequency[digit]++;
		}

		for (int i = 1; i < range; i++) {
			frequency[i] += frequency[i - 1];
		}

		for (int i = length - 1; i >= 0; i--) {
			int digit = (numbers[i] / placeValue) % range;
			sortedValues[frequency[digit] - 1] = numbers[i];
			frequency[digit]--;
		}

		System.arraycopy(sortedValues, 0, numbers, 0, length);
	}

	private static int calculateNumberOfDigitsIn(int number) {
		return (int) Math.log10(number) + 1; // valid only if number > 0
	}

	private static int findMaximumNumberIn(int[] arr) {
		return Arrays.stream(arr).max().getAsInt();
	}

}
