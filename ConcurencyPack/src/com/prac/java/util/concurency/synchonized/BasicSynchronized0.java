package com.prac.java.util.concurency.synchonized;

public class BasicSynchronized0 {
	
	public static void main(String[] args) {
		synchro s=new synchro();
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					
					s.increment();
					//count++;
				}
				
			}
			
		});
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<10000;i++) {
					s.increment();
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
			System.out.println("get count :"+s.getCount());
	}
	

}

class synchro{
	
	private int count=0;

	/**
	public synchronized void increment() {
		count++;
	}
	*/
	
	public void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "synchro [count=" + count + "]";
	}
	
	
}

