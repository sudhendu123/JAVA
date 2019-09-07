package com.prac.java.util.concurency.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
	
	
	public static void main(String[] args) {  
		 int processors = Runtime.getRuntime().availableProcessors();
		    System.out.println("CPU cores: " + processors);
		    //The easiest way to create ExecutorService is to use one of the factory methods of the Executors class.
		    /**
		     * These pools will typically improve the performanceof programs that execute many short-lived asynchronous tasks.
		     * Calls to execute will reuse previously constructedthreads if available.
		     *  If no existing thread is available, a newthread will be created and added to the pool. 
		     *  Threads that havenot been used for sixty seconds are terminated and removed fromthe cache.
		     *   Thus, a pool that remains idle for long enough willnot consume any resources.
		     */
		    
		    ExecutorService executor = Executors.newCachedThreadPool();  
	        for (int i = 0; i < 10; i++) {  
	            Runnable worker = new WorkerThread1("" + i);  
	            executor.execute(worker);//calling execute method of ExecutorService  
	            //execute vs submit, ExecutorService extends Executor
	            //1.Both submit() and execute() methods are used to submit a task to Executor framework for asynchronous execution.
	            //2.The submit() method is declared in ExecutorService interface while execute() method is declared in the Executor interface.
	            //3.execute takes Runnable and submit can take Callable or Runnable as arguments
	            //4.The return type of submit() method is a Future object but return type of execute() method is void.

	          }  
	        executor.shutdown();  
	        while (!executor.isTerminated()) {
	        	//System.out.println("terminated ");   
	        	}  
	  
	        System.out.println("Finished all threads");  
	    }  
}

class WorkerThread1 implements Runnable {  
   private String message;  
   public WorkerThread1(String s){  
       this.message=s;  
   }  
    public void run() {  
       System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
       processmessage();//call processmessage method that sleeps the thread for 2 seconds  
       System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  
   }  
   private void processmessage() {  
       try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }  
   }  
}  
