package com.prac.blocking.queue.delay;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class DelayQueueProducer implements Runnable {
    private BlockingQueue<DelayObject> queue;
    private final Integer numberOfElementsToProduce;
    private Integer delayOfEachProducedMessageMilliseconds;

    DelayQueueProducer(BlockingQueue<DelayObject> queue,
                       Integer numberOfElementsToProduce,
                       Integer delayOfEachProducedMessageMilliseconds) {
        this.queue = queue;
        this.numberOfElementsToProduce = numberOfElementsToProduce;
        this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
    }

    @Override
    public void run() {
        for (int i = 1; i < numberOfElementsToProduce; i++) {
        	//UUID.randomUUID().toString()
        	DelayObject object=null;
        	if(i==4) {
        		object=new DelayObject(i, delayOfEachProducedMessageMilliseconds+9000);
        	}else {
        		object=new DelayObject(i, delayOfEachProducedMessageMilliseconds);
        	}
            
                    
            System.out.println("Put object = " + object);
            try {
                queue.put(object);
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}