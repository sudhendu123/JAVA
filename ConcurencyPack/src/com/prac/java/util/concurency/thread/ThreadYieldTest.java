package com.prac.java.util.concurency.thread;

public class ThreadYieldTest {

	public static void main(String[] args) {
		JavaYieldExp t1 = new JavaYieldExp();
		JavaYieldExp t2 = new JavaYieldExp();
		// this will call run() method
		t1.start();
		t2.start();
		for (int i = 0; i < 4; i++) {
			// Control passes to child thread
			//The yield() method of thread class causes the currently executing thread object to temporarily pause
			//and allow other threads to execute.
			Thread.yield();
			System.out.println(Thread.currentThread().getName() + " in control");
		}
	}
}

class JavaYieldExp extends Thread {
	public void run() {
		for (int i = 0; i < 4; i++)
			System.out.println(Thread.currentThread().getName() + " in control");
	}

}