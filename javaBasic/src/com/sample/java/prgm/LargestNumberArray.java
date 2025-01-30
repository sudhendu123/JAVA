package com.sample.java.prgm;

import java.util.Arrays;

public class LargestNumberArray {

	public static void main(String argss[]) {
		int[] a = new int[] { 22, 3, 550, 4, 11, 100 };
		// Initialize maximum element 
		int max = a[0];
		// Traverse array elements from second and 
        // compare every element with current max   
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}

		System.out.println("The Largest Number is:" + max);
		
		int min = Arrays.stream(a).min().getAsInt();
        int maxx = Arrays.stream(a).max().getAsInt();
        System.out.println("Min = " + min);
        System.out.println("Max = " + maxx);
	}

}
