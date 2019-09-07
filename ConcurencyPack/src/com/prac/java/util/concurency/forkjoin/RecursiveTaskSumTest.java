package com.prac.java.util.concurency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//This architecture is vital for balancing the thread’s workload with the help of the work-stealing algorithm.
										//FORK/JOIN FWK
												//|
							//1.FORK JOIN TASK		2.FORK JOIN POOL
									//|
					//1.RecursiveTask	2.RecursiveAction
public class RecursiveTaskSumTest {
	
	public static void main(String[] args) {
		int nThreads = Runtime.getRuntime().availableProcessors();
	      System.out.println(nThreads);
	      
	      int[] numbers = new int[1000]; 

	      for(int i = 0; i < numbers.length; i++) {
	         numbers[i] = i;
	      }

	      ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
	      Long result = forkJoinPool.invoke(new Sum(numbers,0,numbers.length));
	      System.out.println(result);
	}
	
	static class Sum extends RecursiveTask<Long> {
	      int low;
	      int high;
	      int[] array;

	      Sum(int[] array, int low, int high) {
	         this.array = array;
	         this.low   = low;
	         this.high  = high;
	      }

	      protected Long compute() {
	         
	         if(high - low <= 10) {
	            long sum = 0;
	            
	            for(int i = low; i < high; ++i) 
	               sum += array[i];
	               return sum;
	         } else {	    	
	            int mid = low + (high - low) / 2;
	            Sum left  = new Sum(array, low, mid);
	            Sum right = new Sum(array, mid, high);
	            left.fork();
	            long rightResult = right.compute();
	            long leftResult  = left.join();
	            return leftResult + rightResult;
	         }
	      }
	   }


}
