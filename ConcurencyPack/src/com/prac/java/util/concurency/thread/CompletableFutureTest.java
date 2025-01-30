package com.prac.java.util.concurency.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

	public static void main(String[] args) {
		// Create a CompletableFuture that runs a task asynchronously
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			// Simulate a long-running task
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Result of Future 1";
		});

		// Create another CompletableFuture that runs a task asynchronously
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			// Simulate a long-running task
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Result of Future 2";
		});

		// Combine the results of both futures
		CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
			return result1 + " and " + result2;
		});

		// Wait for the combined future to complete and get the result
		try {
			String combinedResult = combinedFuture.get();
			System.out.println(combinedResult);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
