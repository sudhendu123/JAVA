package com.prac.java.util.concurency.semaphor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Semaphoretest2 {
	
	public static void main(String[] args) {
		Semaphoretest2 test=new Semaphoretest2();
		try {
			System.out.println("Started");
			test.givenLoginQueue_whenReachLimit_thenBlocked();
			//test.givenLoginQueue_whenLogout_thenSlotsAvailable();
			//test.givenDelayQueue_whenReachLimit_thenBlocked();
			//test.givenDelayQueue_whenTimePass_thenSlotsAvailable();
			//test.whenMutexAndMultipleThreads_thenBlocked();
			//test.givenMutexAndMultipleThreads_ThenDelay_thenCorrectCount();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void givenLoginQueue_whenReachLimit_thenBlocked() throws InterruptedException {
        final int slots = 10;
        final ExecutorService executorService = Executors.newFixedThreadPool(slots);
        final LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots)
          .forEach(user -> executorService.execute(loginQueue::tryLogin));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("availableSlots() :"+loginQueue.availableSlots());
        System.out.println("tryLogin :"+loginQueue.tryLogin());	
        //assertEquals(0, loginQueue.availableSlots());
        //assertFalse(loginQueue.tryLogin());
    }

	public void givenLoginQueue_whenLogout_thenSlotsAvailable() throws InterruptedException {
        final int slots = 10;
        final ExecutorService executorService = Executors.newFixedThreadPool(slots);
        final LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots)
          .forEach(user -> executorService.execute(loginQueue::tryLogin));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("availableSlots() :"+loginQueue.availableSlots());	
        System.out.println(loginQueue.availableSlots() > 0);
        
        loginQueue.logout();
        System.out.println(loginQueue.tryLogin());
        //assertEquals(0, loginQueue.availableSlots());
        //assertTrue(loginQueue.availableSlots() > 0);
        //assertTrue(loginQueue.tryLogin());
    }
	
	public void givenDelayQueue_whenReachLimit_thenBlocked() throws InterruptedException {
        final int slots = 50;
        final ExecutorService executorService = Executors.newFixedThreadPool(slots);
        final DelayQueueUsingTimedSemaphore delayQueue = new DelayQueueUsingTimedSemaphore(1, slots);
        IntStream.range(0, slots)
          .forEach(user -> executorService.execute(delayQueue::tryAdd));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(delayQueue.availableSlots());
        System.out.println(delayQueue.tryAdd());
        //assertEquals(0, delayQueue.availableSlots());
        //assertFalse(delayQueue.tryAdd());
    }
	
	public void givenDelayQueue_whenTimePass_thenSlotsAvailable() throws InterruptedException {
        final int slots = 50;
        final ExecutorService executorService = Executors.newFixedThreadPool(slots);
        final DelayQueueUsingTimedSemaphore delayQueue = new DelayQueueUsingTimedSemaphore(1, slots);
        IntStream.range(0, slots)
          .forEach(user -> executorService.execute(delayQueue::tryAdd));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(delayQueue.availableSlots());	
        //assertEquals(0, delayQueue.availableSlots());
        Thread.sleep(1000);
        System.out.println(delayQueue.availableSlots() > 0);
        System.out.println(delayQueue.tryAdd());
        //assertTrue(delayQueue.availableSlots() > 0);
        //assertTrue(delayQueue.tryAdd());
    }
	
	public void whenMutexAndMultipleThreads_thenBlocked() throws InterruptedException {
        final int count = 5;
        final ExecutorService executorService = Executors.newFixedThreadPool(count);
        final CounterUsingMutex counter = new CounterUsingMutex();
        IntStream.range(0, count)
          .forEach(user -> executorService.execute(() -> {
              try {
                  counter.increase();
              } catch (final InterruptedException e) {
                  e.printStackTrace();
              }
          }));
        executorService.shutdown();
        System.out.println(counter.hasQueuedThreads());	
        //assertTrue(counter.hasQueuedThreads());
    }
	
	public void givenMutexAndMultipleThreads_ThenDelay_thenCorrectCount() throws InterruptedException {
        final int count = 5;
        final ExecutorService executorService = Executors.newFixedThreadPool(count);
        final CounterUsingMutex counter = new CounterUsingMutex();
        IntStream.range(0, count)
          .forEach(user -> executorService.execute(() -> {
              try {
                  counter.increase();
              } catch (final InterruptedException e) {
                  e.printStackTrace();
              }
          }));
        executorService.shutdown();
        System.out.println(counter.hasQueuedThreads());
        //assertTrue(counter.hasQueuedThreads());
        Thread.sleep(5000);
        System.out.println(counter.hasQueuedThreads());
        System.out.println(counter.getCount());
        //assertFalse(counter.hasQueuedThreads());
        //assertEquals(count, counter.getCount());
    }
}
