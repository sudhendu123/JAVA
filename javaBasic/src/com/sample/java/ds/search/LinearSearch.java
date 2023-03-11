package com.sample.java.ds.search;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		int[] a1 = { 10, 20, 30, 50, 70, 90 };
		int key = 50;
		search(a1, key);
	}

	public static int search(int[] arr, int x) {
		// edge case
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Invalid input");
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public static void search() {
		int[] arr = { 10, 23, 15, 8, 4, 3, 25, 30, 34, 2, 19 };
		int item, flag = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item ?");
		item = sc.nextInt();
		for (int i = 0; i < 10; i++) {
			if (arr[i] == item) {
				flag = i + 1;
				break;
			} else
				flag = 0;
		}
		if (flag != 0) {
			System.out.println("Item found at location" + flag);
		} else
			System.out.println("Item not found");
	}
}
