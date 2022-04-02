package com.prac.java.util.concurency.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BasicExecutorService {
	public static void main(String[] args) {
        /**
         * Created 2 threads, and assign tasks (Processor(i).run) to the threads
         */
        ExecutorService executor = Executors.newFixedThreadPool(2);//2 Threads
        for (int i = 0; i < 5; i++) { // call the (Processor(i).run) 2 times with 2 threads
            executor.submit(new Processor(i));
        }
        executor.shutdown();
        System.out.println("All tasks submitted.");
        try {
        	/**Blocks until all tasks have completed execution after a shutdown
             * request, or the timeout occurs, or the current thread is
             * interrupted, whichever happens first.*/
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ignored) {
        }
        System.out.println("All tasks completed.");
    }

}

class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Starting task : " + id+" Thread name :"+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("Completed task: " + id +" Thread name :"+Thread.currentThread().getName());
    }
}