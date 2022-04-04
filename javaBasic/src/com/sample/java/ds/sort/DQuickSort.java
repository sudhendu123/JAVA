package com.sample.java.ds.sort;

public class DQuickSort {

	public static void main(String[] args) {
		int i;
		int[] arr = { 90, 23, 101, 45, 65, 23, 67, 89, 34, 23 };
		quickSort(arr, 0, 9);
		System.out.println("\n The sorted array is: \n");
		for (i = 0; i < 10; i++)
			System.out.println(arr[i]);
	}

	public static void quickSort(int arr[], int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(arr, begin, end);

			// Recursively sort elements of the 2 sub-arrays
			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	private static int partition(int arr[], int begin, int end) {
		int pivot = arr[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;

				int swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}

		int swapTemp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = swapTemp;

		return i + 1;
	}

	public static void threeWayQuickSort(int[] a, int begin, int end) {
		if (end <= begin)
			return;

		// partition
		int i = begin;
		int less = begin;
		int greater = end;

		while (i <= greater) {
			if (a[i] < a[less]) {
				int tmp = a[i];
				a[i] = a[less];
				a[less] = tmp;

				i++;
				less++;
			} else if (a[less] < a[i]) {
				int tmp = a[i];
				a[i] = a[greater];
				a[greater] = tmp;

				greater--;
			} else {
				i++;
			}
		}

		threeWayQuickSort(a, begin, less - 1);
		threeWayQuickSort(a, greater + 1, end);
	}
}
