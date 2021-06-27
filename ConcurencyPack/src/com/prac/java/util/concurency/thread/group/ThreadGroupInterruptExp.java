package com.prac.java.util.concurency.thread.group;

public class ThreadGroupInterruptExp {

	public static void main(String arg[]) throws InterruptedException, SecurityException {
		// creating the thread group
		ThreadGroup tg1 = new ThreadGroup("Parent thread");
		ThreadGroup tg2 = new ThreadGroup(tg1, "child thread");

		// creating a thread
		NewThread t1 = new NewThread("Thread-1", tg1);
		System.out.println(t1.getName() + " starts");
		t1.start();

		// interrupting thread group
		//This method interrupts all threads in the thread group.
		tg1.interrupt();

		// creating another thread
		NewThread t2 = new NewThread("Thread-2", tg1);
		System.out.println(t2.getName() + " starts");
		t2.start();
	}

}
