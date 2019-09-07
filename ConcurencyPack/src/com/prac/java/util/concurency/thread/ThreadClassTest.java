package com.prac.java.util.concurency.thread;

public class ThreadClassTest extends Thread{

	public static void main(String[] args) {
		/*Here main thread has one call stack but if we want to execute any other task
		 Then we have to create another thread for new call stack or seperate path of execution**/
		ThreadClassTest t =new ThreadClassTest();
		t.setPriority(Thread.MIN_PRIORITY);  
		t.setDaemon(true);
		t.start();
	}
	
	@Override
	public void run() {
	
		System.out.println("parallel task :"+Thread.currentThread().getName());
	}
}
