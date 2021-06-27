package com.prac.java.util.concurency.thread;

public class ThreadNameTest {

	public static void main(String args[]) {
		TestMultiNaming1 t1 = new TestMultiNaming1();
		TestMultiNaming1 t2 = new TestMultiNaming1();
		TestMultiNaming1 t3=new TestMultiNaming1();  
		System.out.println("Name of t1:" + t1.getName());
		System.out.println("Name of t2:" + t2.getName());

		t1.setPriority(Thread.MIN_PRIORITY);  
		t2.setPriority(Thread.MAX_PRIORITY);  
		t1.setDaemon(true);//now t1 is daemon thread  
		
		t1.start();
		t2.start();
		t3.start();  
		//t3.setDaemon(true);//will throw IllegalThreadStateException here  
		
		t1.setName("Thread Name Test");
		System.out.println("After changing name of t1:" + t1.getName());
	}
}

class TestMultiNaming1 extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName()+": running thread priority is:"+Thread.currentThread().getPriority());  
	}

}