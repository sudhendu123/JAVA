package com.prac.blocking.queue.synchronous;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronousQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;
	final Random random = new Random();

	public SynchronousQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				//String data = UUID.randomUUID().toString();
				String data = Integer.valueOf(new AtomicInteger().incrementAndGet()).toString();
				System.out.println("Put: " + data);
				blockingQueue.put(data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}