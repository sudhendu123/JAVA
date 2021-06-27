package com.prac.java.util.concurency.thread.group;

public class ThreadGroupSetPriorityExp {
	public static void main(String arg[]) throws InterruptedException, SecurityException, Exception {
		// creating the thread group
		ThreadGroup tg1 = new ThreadGroup("Parent threadGroup");
		ThreadGroup tg2 = new ThreadGroup(tg1, "child threadGroup");
		//This method sets the maximum priority of the group.
		tg1.setMaxPriority(Thread.MAX_PRIORITY - 3);
		tg2.setMaxPriority(Thread.MIN_PRIORITY);

		// creating a thread
		NewThread t1 = new NewThread("Thread-1", tg1);
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println(t1.getName() + " starts");
		t1.start();

		// creating another thread
		NewThread t2 = new NewThread("Thread-2", tg2);
		t2.setPriority(Thread.MAX_PRIORITY);
		System.out.println(t2.getName() + " starts");
		t2.start();
	}

}
