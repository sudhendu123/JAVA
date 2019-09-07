package com.prac.blocking.queue.synchronous;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueMain {
	
	public static void main(String[] args) {
		final BlockingQueue<String> synchronousQueue = new SynchronousQueue<String>();

		SynchronousQueueProducer queueProducer = new SynchronousQueueProducer(
				synchronousQueue);
		new Thread(queueProducer).start();

		SynchronousQueueConsumer queueConsumer1 = new SynchronousQueueConsumer(
				synchronousQueue);
		new Thread(queueConsumer1).start();

		SynchronousQueueConsumer queueConsumer2 = new SynchronousQueueConsumer(
				synchronousQueue);
		new Thread(queueConsumer2).start();

	}
}