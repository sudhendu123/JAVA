package com.prac.java.util.concurency.synchonized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicSyncronized1 {
	public static void main(String[] args) {
		new BasicSyncronized1Test().testCode();
	}

}

class BasicSyncronized1Test {

	Random r = new Random();
	List<Integer> ar = new ArrayList<>();
	List<Integer> ar1 = new ArrayList<>();

	// before adding synchronized to method the arrList size was varying
	// after adding synchronized the arrList size are 2k each but its taking some
	// time due to lock on object
	// If one thread has acquired intrinsic lock on the class object then other
	// thread have to wait till the lock is released
	// To solve the issue of object locking on the the both the methods and taking more time
	// We need to have separate object lock with synchronized block
	
	//lock can created on List object also but ,it might lead to some unknown issue of time

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	// public synchronized void task1() {
	public void task1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ar.add(r.nextInt(100));
		}

	}

	// public synchronized void task2() {
	public void task2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ar1.add(r.nextInt(100));
		}

	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			task1();
			task2();
		}
	}

	public void testCode() {
		System.out.println(": starting :");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}

		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}

		});
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("time taken:" + (end - start));
		System.out.println("list1:" + ar.size() + " list2:" + ar1.size());
	}
}
