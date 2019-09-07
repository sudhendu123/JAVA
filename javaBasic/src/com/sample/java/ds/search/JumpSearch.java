package com.sample.java.ds.search;
/**
 * This search is better than liner but not better than binary
 * 
 * time complexcity=O(n/m+(m-1))
 * @author sudhendu.kumar
 *
 */
public class JumpSearch {

	public static void main(String[] args) {
		JumpSearch jump =new JumpSearch();
		int integers[]= {1,23,49,4,56,76};
		System.out.println(jump.jumpSearch(integers,4));
	}
	
	public static int jumpSearch(int[] integers, int elementToSearch) {

	    int arrayLength = integers.length;
	    int jumpStep = (int) Math.sqrt(integers.length);
	    int previousStep = 0;

	    while (integers[Math.min(jumpStep, arrayLength) - 1] < elementToSearch) {
	        previousStep = jumpStep;
	        jumpStep += (int)(Math.sqrt(arrayLength));
	        if (previousStep >= arrayLength)
	            return -1;
	    }
	    while (integers[previousStep] < elementToSearch) {
	        previousStep++;
	        if (previousStep == Math.min(jumpStep, arrayLength))
	            return -1;
	    }

	    if (integers[previousStep] == elementToSearch)
	        return previousStep;
	    return -1;
	}
}
