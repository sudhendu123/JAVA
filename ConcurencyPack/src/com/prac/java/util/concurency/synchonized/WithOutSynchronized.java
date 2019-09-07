package com.prac.java.util.concurency.synchonized;

public class WithOutSynchronized {
	public static void main(String[] args) {
		WithOutSyncMethod s=new WithOutSyncMethod();
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

//Two types of problems arise when multiple threads try to read and write shared data concurrently 
//1.Thread interference errors  eg. racecondition
/**When multiple threads try to read and write a shared variable concurrently,
and these read and write operations overlap in execution,
then the final outcome depends on the order in which the reads and writes take place, 
which is unpredictable. This phenomenon is called Race condition. */
//The section of the code where a shared variable is accessed is called Critical Section.
//2.Memory consistency errors
/**This happens when one thread updates some shared data, but this update is not propagated to other threads, 
and they end up using the old data.
This happens when thread reads data from Thread's local cache(register) in place of main memory.
You can use volatile keyword to avoid memory consistency errors and read is always from main memory*/
class WithOutSyncMethod{
	public void add(int a,int b) {
		a=a+b;
		System.out.println("a= "+a+":"+Thread.currentThread().getName());
		b=b+a;
		System.out.println("b ="+b+":"+Thread.currentThread().getName());
	}
}