package com.prac.java.util.concurency.synchonized;

public class SynchronizedBlockTest {
	int a,b;
	public SynchronizedBlockTest(int a,int b) {
		this.a=a;
		this.b=b;
	}

	public static void main(String[] args) {
		SynchronizedBlockTest s=new SynchronizedBlockTest(1,2);
		Thread t=new Thread() {
			public void run() {
				//SynchronizedBlockTest s=new SynchronizedBlockTest();
				s.add(s);
			}
		};
		t.start();
		t.setName("t");
		
		Thread t1=new Thread() {
			public void run() {
				//SynchronizedBlockTest s=new SynchronizedBlockTest();
				s.add(s);
			}
		};
		t1.start();
		t1.setName("t1");
	}
	
	public void add(SynchronizedBlockTest s) {
		synchronized(s) {
			int a=s.a;
			int b=s.b;
			System.out.println(a+b+":"+Thread.currentThread().getName());
		}
		
		synchronized(this) {
			int a=this.a;
			int b=this.b;
			System.out.println(a+b+":"+Thread.currentThread().getName());
		}
		
	}
}
