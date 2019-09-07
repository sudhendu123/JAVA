package com.sample.java.ds.search;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		//45 is mid
		//array should be sorted in binary search
		int[] arr = { 16, 19, 20, 23, 45, 56, 78, 90, 96, 100 };
		int item, location = -1;
		System.out.println("Enter the item which you want to search");
		Scanner sc = new Scanner(System.in);
		item = sc.nextInt();
		location = binarySearchRecursion(arr, 0, 9, item);
		if (location != -1)
			System.out.println("the location of the item is " + location);
		else
			System.out.println("Item not found");

		System.out.println("Found : " + binarySearch(arr, item));
	}

	public static boolean binarySearch(int[] A, int data) {
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			// Avoid overflow
			int mid = left + (right - left) / 2;
			if (A[mid] == data) {
				System.out.println("mid : "+ (mid+1));
				return true;
			}
			
			if (A[left] < A[mid]) { // the bottom or left half is sorted;
				if (A[left] <= data && data < A[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}else if (A[left] > A[mid]) { // the upper or right half is sorted;
				if (A[mid] < data && data <= A[right])
					left = mid + 1;
				else
					right = mid - 1;
			} else {
				// skip duplicate one, A[start] == A[mid];
				left++;
			}
		}
		return false;
	}

	public static int binarySearchRecursion(int[] a, int beg, int end, int item) {
		int mid;
		if (end >= beg) {
			mid = (beg + end) / 2;
			if (a[mid] == item) {
				return mid + 1;
			} else if (a[mid] < item) {
				return binarySearchRecursion(a, mid + 1, end, item);
			} else {
				return binarySearchRecursion(a, beg, mid - 1, item);
			}

		}
		return -1;
	}

}
