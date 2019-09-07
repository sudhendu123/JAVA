package com.prac.java.util.concurency.executor.service;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

//RecursiveAction represents a task which does not return any value.

public class ForkJoinFibonacciRecursiveAction extends RecursiveAction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7711167702482316810L;
	private static final long threshold = 10;
    private volatile long number;

    public ForkJoinFibonacciRecursiveAction(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    protected void compute() {
        long n = number;
        if (n <= threshold) {
            number = fib(n);
        } else {
        	ForkJoinFibonacciRecursiveAction f1 = new ForkJoinFibonacciRecursiveAction(n - 1);
        	ForkJoinFibonacciRecursiveAction f2 = new ForkJoinFibonacciRecursiveAction(n - 2);
            ForkJoinTask.invokeAll(f1, f2);
            number = f1.number + f2.number;
        }
    }

    private static long fib(long n) {
        if (n <= 1) return n;
        else return fib(n - 1) + fib(n - 2);
    }

}