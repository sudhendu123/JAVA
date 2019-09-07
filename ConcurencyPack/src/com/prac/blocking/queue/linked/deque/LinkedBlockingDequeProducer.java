package com.prac.blocking.queue.linked.deque;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkedBlockingDequeProducer implements Runnable {
    protected BlockingDeque<String> blockingDeque;
    final Random random = new Random();

    public LinkedBlockingDequeProducer(BlockingDeque<String> queue) {
        this.blockingDeque = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //String data = UUID.randomUUID().toString();
            	String data = Integer.valueOf(new AtomicInteger().incrementAndGet()).toString();
                System.out.println("Put: " + data);
                blockingDeque.addFirst(data);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
