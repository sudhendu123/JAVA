package com.prac.java.util.concurency.thread;

import java.util.Scanner;

public class ThreadStopTest1 {
	public static void main(String[] args) {
		Processor pro = new Processor();
		pro.setName("t1");
		pro.start();
		
		Processor pro1 = new Processor();
		pro1.setName("t2");
		pro1.start();
		
		// Wait for the enter key
		System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
		new Scanner(System.in).nextLine();
		pro.shutdown();
	}

}

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		System.out.println(" running :"+running);
		while (running) {
			System.out.println("Running thread: "+Thread.currentThread().getName());

			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}