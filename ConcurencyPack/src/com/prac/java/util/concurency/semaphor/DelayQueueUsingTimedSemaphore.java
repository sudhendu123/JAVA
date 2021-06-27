package com.prac.java.util.concurency.semaphor;

import java.util.concurrent.TimeUnit;


public class DelayQueueUsingTimedSemaphore {
	
	private final TimedSemaphore semaphore;

    DelayQueueUsingTimedSemaphore(long period, int slotLimit) {
        semaphore = new TimedSemaphore(period, TimeUnit.SECONDS, slotLimit);
    }

    boolean tryAdd() {
        return semaphore.tryAcquire();
    }

    int availableSlots() {
        return semaphore.getAvailablePermits();
    }

}
