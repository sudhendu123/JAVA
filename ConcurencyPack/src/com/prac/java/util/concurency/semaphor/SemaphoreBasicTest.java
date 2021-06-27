package com.prac.java.util.concurency.semaphor;

import java.util.concurrent.Semaphore;

public class SemaphoreBasicTest {
	public static void main(String[] args) throws InterruptedException {
		// here 1 is no of permit
		Semaphore sm = new Semaphore(1);

		// decrements permit by 1 if 1 after acquire availablePermits=0,Lock thread
		sm.acquire();
		//sm.tryAcquire();

		// increments permit by 1 if 1 after release availablePermits=2,Unlock Thread
		// sm.release();

		System.out.println("Available no of permit:" + sm.availablePermits());
	}

}
