package com.prac.blocking.queue.priority;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityBlockingQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;
	final Random random = new Random();

	public PriorityBlockingQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		final AtomicInteger numberOfConsumedElements = new AtomicInteger();
		int i=0;
		while (i<10) {
			try {
				int number = numberOfConsumedElements.getAndIncrement();
				//UUID.randomUUID().toString()
				String data = Integer.valueOf(number).toString();
				System.out.println("Put: " + data);
				blockingQueue.put(data);
				Thread.sleep(500);
				i=i+1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}