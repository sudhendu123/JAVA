package com.prac.ds.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * 
 *
 */
public class PermutationSequence60 {
	public static void main(String[] args) {

		System.out.println("permutation:" + getPermutation(3, 3));
	}

	/**
	 * 
	 * Example 1:
	 * 
	 * Input: n = 3, k = 3 Output: "213" Example 2:
	 * 
	 * Input: n = 4, k = 9 Output: "2314" Example 3:
	 * 
	 * Input: n = 3, k = 1 Output: "123"
	 */
	public static String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		int fact = 1;
		for (int i = 1; i < n; i++) {
			fact = fact * i;
			list.add(i);
		}
		list.add(n);
		k = k - 1;
		String ans = "";
		while (true) {
			ans += list.get(k / fact);
			list.remove(k / fact);
			if (list.size() == 0) {
				break;
			}
			k = k % fact;
			fact = fact / list.size();
		}
		return ans;
	}

	

}
