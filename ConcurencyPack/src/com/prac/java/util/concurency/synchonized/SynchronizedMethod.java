package com.prac.java.util.concurency.synchonized;

public class SynchronizedMethod {

	public static void main(String[] args) {
		SyncMethod s=new SyncMethod();
		Thread t=new Thread() {
			public void run() {
				//SynchronizedMethod s=new SynchronizedMethod();
				s.add(1, 2);
			}
		};
		t.start();
		t.setName("t");
		
		Thread t1=new Thread() {
			public void run() {
				//SynchronizedMethod s=new SynchronizedMethod();
				s.add(1, 3);
			}
		};
		t1.start();
		t1.setName("t1");
	}
	
	
	
}
//Synchronization
//1.This guarantees that the access to a shared variable is Atomic, and multiple threads do not interfere.
//2.This guarantees that changes done by one thread are visible to others.
//Java’s synchronized keyword guarantees both mutual exclusion and visibility. 
/** 
Mutual Exclusion: It means that only one thread or process can execute a block of code (critical section) at a time.
Visibility: It means that changes made by one thread to shared data are visible to other threads.
 * */
class SyncMethod{
	public synchronized  void add(int a,int b) {
		a=a+b;
		System.out.println("a = "+a+":"+Thread.currentThread().getName());
		b=b+a;
		System.out.println("b= "+b+":"+Thread.currentThread().getName());
	}
}