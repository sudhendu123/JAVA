package com.prac.java.util.concurency.thread;

public class TestShutdownHook {

	public static void main(String[] args) {

		//So if you want to execute some code before JVM shuts down, use shutdown hook.
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Shutdown Hook is running !");
			}
		});
		System.out.println("Application Terminating ...");
	}
}
