package com.sample.java.ds.sort;

import java.util.Arrays;

public class CSelectionSort {
	
	public static void main(String[] args) {
		int[] input = { 5, 4, 1, 6, 2 };
        CSelectionSort.sortAscending(input);
        System.out.println(" asc:"+Arrays.asList(input));
        CSelectionSort.sortDescending(input);
        System.out.println(" desc:"+Arrays.asList(input));
	}
//i,j,k k=holds smallest element in per phase iteration,
//and last per phase iteration, swap the element in k with i element
//per swap selection sort gets the smallest elements
//selection is not adaptive,even though the array is sorted it will take perform the operation and same time
//it is not stable,As if 2 same elements are present they will be swapped and order is not preserved	
	 public static void sortAscending(final int[] arr) {
	        for (int i = 0; i < arr.length - 1; i++) {
	            int minElementIndex = i;
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[minElementIndex] > arr[j]) {
	                    minElementIndex = j;
	                }
	            }

	            if (minElementIndex != i) {
	                int temp = arr[i];
	                arr[i] = arr[minElementIndex];
	                arr[minElementIndex] = temp;
	            }
	        }
	    }

	    public static void sortDescending(final int[] arr) {
	        for (int i = 0; i < arr.length - 1; i++) {
	            int maxElementIndex = i;
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[maxElementIndex] < arr[j]) {
	                    maxElementIndex = j;
	                }
	            }

	            if (maxElementIndex != i) {
	                int temp = arr[i];
	                arr[i] = arr[maxElementIndex];
	                arr[maxElementIndex] = temp;
	            }
	        }
	    }
}
