package com.sample.java.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseArray {
	public static void main(String[] args) {

		ArrayList<Integer> inn=new ArrayList<Integer>();
		inn.add(1);
		inn.add(2);
		inn.add(6);
		inn.add(3);
		reverseArray(inn, 2);
	}

	static int helper(int l, int r, ArrayList<Integer> arr) {
		// base condition
		if (l >= r)
			return 1;

		// do the small task
		Collections.swap(arr, l, r);

		// ask recursion to do the remaining task
		return helper(l + 1, r - 1, arr);
	}

	public static void reverseArray(ArrayList<Integer> arr, int m) {
		// Write your code here.
		helper(m + 1, arr.size() - 1, arr);
	}
	/*
	 * time complexity : O(n) space complexity : O(n)
	 */

}
