package com.prac.blocking.queue.delay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueExampleMain {
	public static void main(String[] args) {
		final BlockingQueue<DelayObject> queue = new DelayQueue<DelayObject>();

		DelayQueueProducer queueProducer = new DelayQueueProducer(queue,10,10);
		new Thread(queueProducer).start();

		DelayQueueConsumer queueConsumer1 = new DelayQueueConsumer(queue,10);
		new Thread(queueConsumer1).start();

		DelayQueueConsumer queueConsumer2 = new DelayQueueConsumer(queue,10);
		new Thread(queueConsumer2).start();

	}
}