package com.prac.java.util.concurency.thread.group;

public class ThreadGroupResumeExp {

	public static void main(String arg[]) throws InterruptedException, SecurityException, Exception {
		// creating the threadGroup
		ThreadGroup tg1 = new ThreadGroup("Parent thread");
		ThreadGroup tg2 = new ThreadGroup(tg1, "Child thread");

		// creating a thread
		NewThread t1 = new NewThread("Thread-1", tg1);
		System.out.println("Starting of Thread-1");
		t1.start();
		// this will suspend all the threads
		tg1.suspend();

		// creating another thread
		NewThread t2 = new NewThread("Thread-2", tg2);
		System.out.println("Starting of Thread-2");
		t2.start();

		// this will resume all the threads suspended by tg1
		//This method is used to resume all threads in the thread group which was suspended using suspend() method.
		tg1.resume();
	}

}
