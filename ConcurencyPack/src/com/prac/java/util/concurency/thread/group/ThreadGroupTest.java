package com.prac.java.util.concurency.thread.group;

public class ThreadGroupTest {

	public static void main(String[] args) {
		// creating the thread group
				ThreadGroup tg1 = new ThreadGroup("parent thread group");
				ThreadGroup tg2 = new ThreadGroup(tg1, "child threadGroup");

				 
				// creating a thread
				NewThread t1 = new NewThread("Thread-1", tg1);
				System.out.println(t1.getName() + " starts");
				t1.start();

				 
				// creating another thread
				NewThread t2 = new NewThread("Thread-2", tg1);
				System.out.println(t2.getName() + " starts");
				t2.start();
				
				// creating another thread
				NewThread t3 = new NewThread("Thread-3", tg1);
				System.out.println(t3.getName() + " starts");
				t3.start();
				
				// creating another thread
				NewThread t4 = new NewThread("Thread-4", tg1);
				System.out.println(t4.getName() + " starts");
				t4.start();
				tg1.interrupt();
				
				//Thread.currentThread().getThreadGroup().interrupt();
	}
}
