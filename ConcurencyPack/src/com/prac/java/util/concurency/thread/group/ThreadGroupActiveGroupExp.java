package com.prac.java.util.concurency.thread.group;

public class ThreadGroupActiveGroupExp {

	public static void main(String arg[]) {
		// creating the thread group
		ThreadGroup tg1 = new ThreadGroup("parent thread group");
		ThreadGroup tg2 = new ThreadGroup(tg1, "child threadGroup");
		ThreadGroup tg3 = new ThreadGroup(tg1, "child threadGroup");

		// creating the threads
		NewThread t1 = new NewThread("Thread-1", tg1);
		System.out.println(t1.getName() + " starts");
		// this will call the run() method
		t1.start();

		// checking the number of active thread
		//This method returns an estimate of the number of active groups in the thread group and its subgroups.
		System.out.println("Number of active thread group: " + tg1.activeGroupCount());
	}

}
