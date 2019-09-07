package com.prac.blocking.queue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed {
    private String data;
    private long startTime;
    private int intData;

    DelayObject(String data, long delayInMilliseconds) {
        this.data = data;
        this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }

    public DelayObject(int andIncrement, Integer delayOfEachProducedMessageMilliseconds) {
		this.intData=andIncrement;
		this.startTime = System.currentTimeMillis() +delayOfEachProducedMessageMilliseconds;
	}

	@Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.startTime - ((DelayObject) o).startTime);
    }

	@Override
	public String toString() {
		return "DelayObject [data=" + data + ", startTime=" + startTime + ", intData=" + intData + "]";
	}

    
}