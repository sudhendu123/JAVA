package com.prac.java.util.concurency.thread;

public class ThreadRunnableTest1 {

	public static void main(String args[]) {
		Multi3 m1 = new Multi3();
		Thread t1 = new Thread(m1);
		t1.start();
	}
}

class Multi3 implements Runnable {
	public void run() {
		System.out.println("thread is running...");
	}

}