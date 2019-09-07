package com.prac.blocking.queue.linked.deque;

import java.util.concurrent.BlockingDeque;

public class LinkedBlockingDequeConsumer implements Runnable {

    protected BlockingDeque<String> blockingDeque;

    public LinkedBlockingDequeConsumer(BlockingDeque<String> queue) {
        this.blockingDeque = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = blockingDeque.takeFirst();
                System.out.println(Thread.currentThread().getName()
                        + " take(): " + data);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}