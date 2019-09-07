package com.prac.java.util.concurency.forkjoin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

public class SumRecursiveAction extends RecursiveAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// A thread can easily handle, let's say, five elements
    private static final int SEQUENTIAL_THRESHOLD = 5;

    // The list with the numbers
    private List<Long> data;

    // Since compute() doesn't take parameters, you have to
    // pass in the task's constructor the data to work
    public SumRecursiveAction(List<Long> data) {
        this.data = data;
    }

    @Override
    protected void compute() {
        if (data.size() <= SEQUENTIAL_THRESHOLD) { // base case
            long sum = computeSumDirectly();
            System.out.format("Sum of %s: %d\n", data.toString(), sum);
        } else { // recursive case
            // Calculate new range
            int mid = data.size() / 2;
            SumRecursiveAction firstSubtask =
                    new SumRecursiveAction(data.subList(0, mid));
            SumRecursiveAction secondSubtask =
                    new SumRecursiveAction(data.subList(mid, data.size()));

            firstSubtask.fork(); // queue the first task
            secondSubtask.compute(); // compute the second task
            firstSubtask.join(); // wait for the first task result

            // Or simply call
            //invokeAll(firstSubtask, secondSubtask);
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
                .longs(11, 1, 5)
                .boxed()
                .collect(Collectors.toList());

        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Pool parallelism: " + pool.getParallelism());
        SumRecursiveAction task = new SumRecursiveAction(data);
        pool.invoke(task);
    }
}