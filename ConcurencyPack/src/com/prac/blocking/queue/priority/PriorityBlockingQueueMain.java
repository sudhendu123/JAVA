package com.prac.blocking.queue.priority;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PriorityBlockingQueueMain {
	public static void main(String[] args) {
		final BlockingQueue<String> priorityBlockingQueue = new LinkedBlockingQueue<String>();

		PriorityBlockingQueueProducer queueProducer = new PriorityBlockingQueueProducer(
				priorityBlockingQueue);
		new Thread(queueProducer).start();

		PriorityBlockingQueueConsumer queueConsumer1 = new PriorityBlockingQueueConsumer(
				priorityBlockingQueue);
		new Thread(queueConsumer1).start();

		PriorityBlockingQueueConsumer queueConsumer2 = new PriorityBlockingQueueConsumer(
				priorityBlockingQueue);
		new Thread(queueConsumer2).start();

	}
}
