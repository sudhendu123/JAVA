package com.prac.java.util.concurency.thread;

public class ThreadRunnableTest implements Runnable{

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Thread t =new Thread(new runThreadTest());
		Thread t1 =new Thread(new ThreadRunnableTest());
		t1.start();
		t.start();
		mainThreadTask1();
		mainThreadTask2();
	}
	
	public static void mainThreadTask1() {
		System.out.println("mainThreadTask1 "+Thread.currentThread().getName());
	}
	
	public static void mainThreadTask2() {
		System.out.println("mainThreadTask2 "+Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println("main parallel task :"+Thread.currentThread().getName());
		
	}
}

class runThreadTest implements Runnable{

	@Override
	public void run() {
		
		System.out.println("parallel task :"+Thread.currentThread().getName());
		
	}
	
}
