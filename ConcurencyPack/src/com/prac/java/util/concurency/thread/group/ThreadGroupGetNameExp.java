package com.prac.java.util.concurency.thread.group;

public class ThreadGroupGetNameExp {

	public static void main(String arg[]) throws InterruptedException, SecurityException, Exception {
		// creating the threadGroup
		ThreadGroup tg1 = new ThreadGroup("Parent thread");
		ThreadGroup tg2 = new ThreadGroup(tg1, "Child thread");

		// creating a thread
		NewThread t1 = new NewThread("Thread-1", tg1);
		System.out.println("First threadGroup's name: " + t1.getThreadGroup().getName());

		// creating another thread
		//This method returns the name of the thread group.
		NewThread t2 = new NewThread("Thread-2", tg2);
		System.out.println("Second threadGroup's name: " + t2.getThreadGroup().getName());
	}
}
