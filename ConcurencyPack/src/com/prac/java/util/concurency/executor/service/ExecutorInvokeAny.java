package com.prac.java.util.concurency.executor.service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorInvokeAny {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		String result = null;
		try {
			//Executes the given tasks, returning the resultof one that has completed successfully 
			//(i.e., without throwingan exception), if any do. Upon normal or exceptional return
			//,tasks that have not completed are cancelled.
			//The results of this method are undefined if the givencollection is modified while this operation is in progress.
			result = executorService.invokeAny(callables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("result = " + result);

		executorService.shutdown();
	}
}
