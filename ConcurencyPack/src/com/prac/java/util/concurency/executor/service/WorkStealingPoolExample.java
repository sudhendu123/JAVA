package com.prac.java.util.concurency.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkStealingPoolExample {
	
	public static void main(final String[] arguments) throws InterruptedException {  
		/**
		 * 	Creates a work-stealing thread pool using all available processors as its target parallelism level.
			Returns:the maximum number of processors available to the virtual machine; never smaller than one
		 */
	      ExecutorService excr = Executors.newWorkStealingPool();  
	      ThreadPoolExecutor mypool = (ThreadPoolExecutor)  Executors.newCachedThreadPool();;  
	      System.out.println("size of mypool: " + mypool.getPoolSize());  
	      excr.submit(new Threadimpl());  
	      excr.submit(new Threadimpl());  
	      System.out.println("Total number threads scheduled): "+ mypool.getTaskCount());  
	      excr.shutdown();  
	   }    
	  
	   static class Threadimpl implements Runnable {  
	  
	      public void run() {  
	           
	         try {  
	            Long num = (long) (Math.random() / 30);  
	            System.out.println("Thread Name: " +Thread.currentThread().getName());  
	               TimeUnit.SECONDS.sleep(num);  
	            System.out.println("after sleep Thread Name: " +Thread.currentThread().getName());  
	         } catch (InterruptedException e) {  
	            e.printStackTrace();  
	         }  
	      }  
	   }  

}
