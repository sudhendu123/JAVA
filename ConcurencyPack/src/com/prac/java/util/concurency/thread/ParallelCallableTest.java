package com.prac.java.util.concurency.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ParallelCallableTest {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		ExecutorService executor = Executors.newFixedThreadPool(2);

		Callable<Integer> evenSumTask = new SumTask(numbers, 0);
		Callable<Integer> oddSumTask = new SumTask(numbers, 1);

		Future<Integer> evenSumFuture = executor.submit(evenSumTask);
		Future<Integer> oddSumFuture = executor.submit(oddSumTask);

		try {
			int evenSum = evenSumFuture.get();
			int oddSum = oddSumFuture.get();

			System.out.println("Sum of even index numbers: " + evenSum);
			System.out.println("Sum of odd index numbers: " + oddSum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}

		// anaonymus class

		ExecutorService executor1 = Executors.newFixedThreadPool(2);

		Callable<Integer> evenSumTask1 = new Callable<Integer>() {
			@Override
			public Integer call() {
				int sum = 0;
				for (int i = 0; i < numbers.size(); i += 2) {
					sum += numbers.get(i);
				}
				return sum;
			}
		};

		Callable<Integer> oddSumTask1 = new Callable<Integer>() {
			@Override
			public Integer call() {
				int sum = 0;
				for (int i = 1; i < numbers.size(); i += 2) {
					sum += numbers.get(i);
				}
				return sum;
			}
		};

		Future<Integer> evenSumFuture1 = executor1.submit(evenSumTask);
		Future<Integer> oddSumFuture1 = executor1.submit(oddSumTask);

		try {
			int evenSum = evenSumFuture1.get();
			int oddSum = oddSumFuture1.get();

			System.out.println("Sum of even index numbers: " + evenSum);
			System.out.println("Sum of odd index numbers: " + oddSum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}
}

class SumTask implements Callable<Integer> {
	private final List<Integer> numbers;
	private final int startIndex;

	public SumTask(List<Integer> numbers, int startIndex) {
		this.numbers = numbers;
		this.startIndex = startIndex;
	}

	@Override
	public Integer call() {
		int sum = 0;
		for (int i = startIndex; i < numbers.size(); i += 2) {
			sum += numbers.get(i);
		}
		return sum;
	}
}
