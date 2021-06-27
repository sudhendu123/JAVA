package com.prac.java.util.concurency.thread;

public class CSThreadExceptionTest {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// Code that will run in a new thread
				//throw new RuntimeException("Intentional Exception");
				int i=1/0;
			}
		});

		thread.setName("Error thread");

		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						"Error in run() :" + t.getName() + " error msg :" + e.getMessage());
			}
		});
		thread.start();

	}

}
