package com.prac.java.util.concurency.thread.group;

public class ThreadGroupIsDaemonExp {
	public static void main(String arg[]) throws InterruptedException, SecurityException, Exception {
		// creating a threadGroup
		ThreadGroup tg = new ThreadGroup("Parent thread");
		// creating a thread
		NewThread t1 = new NewThread("Thread-1", tg);
		t1.start();

		//This method tests if the thread group is a daemon thread group.
		// returns false if this thread group is not a daemon thread group
		System.out.println("Is " + tg.getName() + " a daemon threadGroup? " + tg.isDaemon());
	}

}
