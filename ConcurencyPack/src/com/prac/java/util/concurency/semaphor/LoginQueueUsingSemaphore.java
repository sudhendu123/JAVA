package com.prac.java.util.concurency.semaphor;

import java.util.concurrent.Semaphore;

public class LoginQueueUsingSemaphore {
	
	private final Semaphore semaphore;

    LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    //tryAcquire() – return true if a permit is available immediately 
    //and acquire it otherwise return false, but acquire() acquires a permit and blocking until one is available
    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    //release() – release a permit
    void logout() {
        semaphore.release();
    }

    //availablePermits() – return number of current permits available
    int availableSlots() {
        return semaphore.availablePermits();
    }

}
