package com.prac.java.util.concurency.synchonized;

public class BasicSyncronized {
	//when we run the program multiple times we can see the result is deviating from the actual result 20k
	//result will deviate when we run uncomment count++,volatile also doesn't solve the problem
	//to solve the issue we need to add the counter to synchronized method
	
	
	//private volatile int count=0;
	private int count=0;
	
	public synchronized void increment() {
		count++;
	}
	
	public static void main(String[] args) {
		BasicSyncronized b=new BasicSyncronized();
		b.task();
	}
	
	public void task() {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					increment();
					//count++;
				}
				
			}
			
		});
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					increment();
					//count++;
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("count :"+count);
	}

}
