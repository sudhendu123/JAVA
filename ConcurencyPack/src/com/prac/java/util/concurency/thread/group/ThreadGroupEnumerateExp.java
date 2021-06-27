package com.prac.java.util.concurency.thread.group;

public class ThreadGroupEnumerateExp {

	public static void main(String arg[]) {
		// creating the ThreadGroup
		ThreadGroup g1 = new ThreadGroup("Parent thread");
		// creating a child ThreadGroup for parent ThreadGroup
		ThreadGroup g2 = new ThreadGroup(g1, "child thread");

		// creating a thread
		NewThread t1 = new NewThread("Thread-1", g1);
		System.out.println("Starting of Thread-1");
		t1.start();
		// creating another thread
		NewThread t2 = new NewThread("Thread-2", g1);
		System.out.println("Starting of Thread-2");
		t2.start();

		// returns the number of threads put into the array
		//This method copies into the specified array every active thread in the thread group and its subgroups.
		Thread[] tarray = new Thread[g1.activeCount()];
		int count = g1.enumerate(tarray);

		// prints active threads
		for (int i = 0; i < count; i++)
			System.out.println(tarray[i].getName() + " found");
	}

}
