package com.prac.java.util.concurency.countdown;

import java.util.concurrent.CountDownLatch;

public class DevTeam extends Thread {
	private CountDownLatch countDownLatch;

	public DevTeam(CountDownLatch countDownLatch, String name) {
		super(name);
		this.countDownLatch = countDownLatch;
	}

	@Override
    public void run() {
        System.out.println("Task assigned to development team " +Thread.currentThread().getName());
        try {
                Thread.sleep(3000);
        } catch (InterruptedException ex) {
                ex.printStackTrace();
        }
        System.out.println("Task finished by development team "+Thread.currentThread().getName());
        
        //Each thread calls countDown() method on task completion.
        countDownLatch.countDown();
    }
}