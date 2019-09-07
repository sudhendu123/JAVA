package com.prac.java.util.concurency.executor.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorInvokeAll {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callablesTaskSet = new HashSet<Callable<String>>();

		callablesTaskSet.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callablesTaskSet.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callablesTaskSet.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		List<Future<String>> futures = null;
		try {
			futures = executorService.invokeAll(callablesTaskSet);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for(Future<String> future : futures){
		    System.out.println("future.get = " + future.get());
		}

		executorService.shutdown();
	}

}
