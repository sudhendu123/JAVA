package com.prac.java.util.concurency.thread.group;

//The activeCount() method of ThreadGroup class determines 
//if the currently running thread has permission to modify the thread group.It doesn't return any value.
public class ThreadGroupCkeckAccessExp {

	public static void main(String arg[]) throws InterruptedException, SecurityException {
		// creating a ThreadGroup
		ThreadGroup g1 = new ThreadGroup("Parent thread");
		// creating a child ThreadGroup for parent ThreadGroup
		ThreadGroup g2 = new ThreadGroup(g1, "child thread");

		// creating a thread
		NewThread t1 = new NewThread("Thread-1", g1);
		t1.start();
		// creating another thread
		NewThread t2 = new NewThread("Thread-2", g1);
		t2.start();

		// Check for access permission of current running thread
		g1.checkAccess();
		System.out.println(g1.getName() + " has access");
		g2.checkAccess();
		System.out.println(g2.getName() + " has access");
	}
}

class NewThread extends Thread {
	NewThread(String threadname, ThreadGroup tg) {
		super(tg, threadname);
	}

	public void run() {
		System.out.println(Thread.currentThread().getName()+" : "+Thread.interrupted());
		if (!Thread.interrupted()) {
			System.out.println(Thread.currentThread().getName() + " Thread is intrupted ");

			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					System.out.println(Thread.currentThread().getName() + " interrupted");
				}
			}
			System.out.println(Thread.currentThread().getName() + " completed executing");
		}
	}
}
