package com.prac.java.util.concurency.executor.service;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

//RecursiveTask represents a task which returns a value.
public class ForkJoinAddRecursiveTask extends RecursiveTask<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 156865908255623515L;
	private final long[] numbers;
    private final int start;
    private final int end;
    public static final long threshold = 10_000;

    public ForkJoinAddRecursiveTask(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinAddRecursiveTask(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
    	System.out.println(ForkJoinAddRecursiveTask.startForkJoinSum(1_000_000));
	}
    @Override
    protected Long compute() {

        int length = end - start;
        if (length <= threshold) {
            return add();
        }

        ForkJoinAddRecursiveTask firstTask = new ForkJoinAddRecursiveTask(numbers, start, start + length / 2);
        firstTask.fork(); //start asynchronously

        ForkJoinAddRecursiveTask secondTask = new ForkJoinAddRecursiveTask(numbers, start + length / 2, end);

        Long secondTaskResult = secondTask.compute();
        Long firstTaskResult = firstTask.join();

        return firstTaskResult + secondTaskResult;

    }

    private long add() {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }

    public static long startForkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinAddRecursiveTask(numbers);
        return new ForkJoinPool().invoke(task);
    }

}