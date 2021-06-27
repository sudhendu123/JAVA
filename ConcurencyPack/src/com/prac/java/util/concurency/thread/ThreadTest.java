package com.prac.java.util.concurency.thread;

public class ThreadTest {

	public static void main(String args[]) {
		Multi t1 = new Multi();
		t1.start();

		TestSleepMethod1 t2 = new TestSleepMethod1();
		TestSleepMethod1 t3 = new TestSleepMethod1();

		t2.start();
		t3.start();
		// IllegalThreadStateException is thrown
		t3.start();

		TestCallRun2 t4 = new TestCallRun2();
		TestCallRun2 t5 = new TestCallRun2();
		//doesn't create a new stack,behaves as normal method
		//there is no context-switching because here t4 and t5
		//will be treated as normal object not thread object.
		t4.run();
		t5.run();
	}
}

class Multi extends Thread {
	public void run() {
		System.out.println("thread is running...");
	}

}

class TestSleepMethod1 extends Thread {
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println("Thread sleep: " + i);
		}
	}
}

class TestCallRun2 extends Thread {
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

}