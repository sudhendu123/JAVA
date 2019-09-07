package com.prac.java.util.concurency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLockTest {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {

		    @Override
		    public void run() {
		    	SimpleLockTest lt=new SimpleLockTest();
		    	System.out.println(Thread.currentThread().getName()+":"+lt.syncInc());
		    }
		            
		});
		        
		thread.start();
		thread.setName("thread");
		
		Thread thread1 = new Thread(new Runnable() {

		    @Override
		    public void run() {
		    	SimpleLockTest lt=new SimpleLockTest();
		    	System.out.println(Thread.currentThread().getName()+":"+lt.syncInc());
		    }
		            
		});
		        
		thread1.start();
		thread1.setName("thread1");

		SimpleLockTest lt=new SimpleLockTest();
		System.out.println(Thread.currentThread().getName()+":"+lt.syncInc());
	}
	
	//simple lock
	public int syncInc(){
	    synchronized(this){
	    	System.out.println(Thread.currentThread().getName()+":"+count);
	      return ++count;
	    }
	  }
	
	public int lockInc(){
	    lock.lock();
	    int newCount =0;
	    try {
	    	newCount = ++count;
	    }finally {
	    	lock.unlock();
	    }
	    
	    
	    return newCount;
	  }
}
