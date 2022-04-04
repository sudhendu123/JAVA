package com.sample.java.ds.sort;


import java.util.stream.IntStream;
//swap the elment in the array and move the max to the right of the array
public class ABubbleSort {
	public static void main(String[] args) {
		Integer[] array = { 2, 1, 4, 6, 3, 5 };
		ABubbleSort bubbleSort = new ABubbleSort();
        bubbleSort.bubbleSort(array);
        bubbleSort.optimizedBubbleSort(array);
	}

    void bubbleSort(Integer[] arr) {
        int n = arr.length;
        IntStream.range(0, n - 1)
          .flatMap(i -> IntStream.range(1, n - i))
          .forEach(j -> {
              if (arr[j - 1] > arr[j]) {
                  int temp = arr[j];
                  arr[j] = arr[j - 1];
                  arr[j - 1] = temp;
              }
          });
    }

    void optimizedBubbleSort(Integer[] arr) {
        int i = 0, n = arr.length;

        boolean swapNeeded = true;
        while (i < n - 1 && swapNeeded) {
            swapNeeded = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {

                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapNeeded = true;
                }
            }
            if (!swapNeeded)
                break;
            i++;
        }
    }
}
