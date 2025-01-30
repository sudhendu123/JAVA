package com.prac.java.util.concurency.lock;

public class ObjectLevelLock implements Runnable {

	public static void main(String[] args) {
		
		ObjectLevelLock b1 = new ObjectLevelLock();
        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b1);
         
        ObjectLevelLock b2 = new ObjectLevelLock();
        Thread t3 = new Thread(b2);
         
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
         
        t1.start();
        t2.start();
        t3.start();

	}
	
	@Override
	public void run() {
		objectLock();
	}

	public void objectLock() {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("synchronized block " + Thread.currentThread().getName() +" start");
			System.out.println("synchronized block " + Thread.currentThread().getName() + " end");
		}
	}
	
	

}
