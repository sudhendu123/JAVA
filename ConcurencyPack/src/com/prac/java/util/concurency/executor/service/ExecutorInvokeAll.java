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
			//Executes the given tasks, returning a list of Futures holding their status and results when all complete. 
			//Future.isDone is true for eachelement of the returned list.
			//Note that a completed task could haveterminated either normally or by throwing an exception.
			//The results of this method are undefined if the givencollection is modified while this operation is in progress.
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
