package com.prac.java.util.concurency.forkjoin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class SumRecursiveTask extends RecursiveTask<Long> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// A thread can easily handle, let's say for testing, five elements
    //private static final int SEQUENTIAL_THRESHOLD = 5;
    // To compare the performance, I'm testing with 100,000
    private static final int SEQUENTIAL_THRESHOLD = 100_000;

    // The list with the numbers
    private List<Long> data;

    // Since compute() doesn't take parameters, you have to
    // pass in the task's constructor the data to work
    public SumRecursiveTask(List<Long> data) {
        this.data = data;
    }

    //Return type matches the generic
    @Override
    protected Long compute() {
        if (data.size() <= SEQUENTIAL_THRESHOLD) { // base case
            long sum = computeSumDirectly();
            //System.out.format("Sum of %s: %d\n", data.toString(), sum);
            return sum;
        } else { // recursive case
            // Calculate new range
            int mid = data.size() / 2;
            SumRecursiveTask firstSubtask =
                    new SumRecursiveTask(data.subList(0, mid));
            SumRecursiveTask secondSubtask =
                    new SumRecursiveTask(data.subList(mid, data.size()));

            // queue the first task
            firstSubtask.fork();

            // Return the sum of all subtasks
            return secondSubtask.compute()
                    +
                    firstSubtask.join();
        }
    }

    /** Method that calculates the sum */
    private long computeSumDirectly() {
        long sum = 0;
        for (Long l: data) {
            sum += l;
        }
        return sum;
    }

    public static void main(String[] args) {
        Random random = new Random();

        List<Long> data = random
                .longs(10, 1, 5)
                .boxed()
                .collect(Collectors.toList());

        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Pool parallelism: " + pool.getParallelism());
        SumRecursiveTask task = new SumRecursiveTask(data);
        System.out.println("Sum: " + pool.invoke(task));
    }
}