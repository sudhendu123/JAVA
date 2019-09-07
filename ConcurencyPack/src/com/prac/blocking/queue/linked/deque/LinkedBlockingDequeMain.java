package com.prac.blocking.queue.linked.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeMain {

	public static void main(String[] args) {
        final BlockingDeque<String> priorityBlockingQueue = new LinkedBlockingDeque<String>();

        LinkedBlockingDequeProducer queueProducer = new LinkedBlockingDequeProducer(
                priorityBlockingQueue);
        new Thread(queueProducer).start();

        LinkedBlockingDequeConsumer queueConsumer1 = new LinkedBlockingDequeConsumer(
                priorityBlockingQueue);
        new Thread(queueConsumer1).start();

        LinkedBlockingDequeConsumer queueConsumer2 = new LinkedBlockingDequeConsumer(
                priorityBlockingQueue);
        new Thread(queueConsumer2).start();
    }
}
