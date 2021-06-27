package com.prac.java.util.concurency.thread;

import java.util.HashMap;
import java.util.Map;

public class ThreadStopTest {

	public static void main(String args[]) 
	{ 
		MyThread t1 = new MyThread(); 
		Thread t2=new Thread(t1);
		t2.setName("t.t1");
		t2.start();
		
		Thread t5=new Thread(t1);
		t5.setName("t.t2");
		t5.start();
		
		Thread t6=new Thread(t1);
		t6.setName("t.t3");
		t6.start();
		
		MyThread t3 = new MyThread(); 
		Thread t7=new Thread(t3);
		t7.setName("t2.t1");
		t7.start();
		
		Thread t8=new Thread(t3);
		t8.setName("t2.t2");
		//t8.start();
		
		Thread t9=new Thread(t3);
		t9.setName("t2.t3");
		//t9.start();
		 
		System.out.println("Exiting the main Thread"); 
	} 
}


//stopping a thread 
//using the interrupt() method 

class MyThread implements Runnable { 

	int i=0;
	Map<String,Integer> m=new HashMap<>();

	public void run() 
	{ 

		String thredaName=Thread.currentThread().getName();
		System.out.println(thredaName+" Thread begin."); 
		if(Thread.currentThread().getName().contains("t.")) {
			i++;
			System.out.println("count "+i);
			
			m.put(thredaName.substring(0, thredaName.indexOf('.')), i++);
		}else {
			Thread.currentThread().interrupt();
		}
		
		if(!Thread.interrupted()) {
			TaskTest test=new TaskTest();
			int q = test.testTask();
			System.out.println(thredaName+" Thread not interupted ="+Thread.currentThread().getName()); 
		}
		
		
		System.out.println(thredaName+" Thread end."); 
	} 
} 

class TaskTest{
	
	public int testTask() {
		return 1;
	}
}
