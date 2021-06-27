package com.prac.java.util.concurency.thread;

public class ThreadSleepTest {
	public static void main(String args[]) {
		TestSleepMethody t1 = new TestSleepMethody();
		TestSleepMethody t2 = new TestSleepMethody();

		t1.start();
		t2.start();
	}
}

//The sleep() method of Thread class is used to sleep a thread for the specified amount of time.
class TestSleepMethody extends Thread {
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				//public static void sleep(long miliseconds)throws InterruptedException
				Thread.sleep(500);
				//public static void sleep(long miliseconds, int nanos)throws InterruptedException
				// thread to sleep for 1000 milliseconds plus 500 nanoseconds
	            //Thread.sleep(1000, 500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

}