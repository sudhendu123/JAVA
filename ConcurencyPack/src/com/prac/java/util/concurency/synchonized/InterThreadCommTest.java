package com.prac.java.util.concurency.synchonized;

import java.util.ArrayList;
import java.util.List;

public class InterThreadCommTest {

	
	
	
	public static void main(String[] args) {
		InterThreadCommTest test=new InterThreadCommTest();
		List<String> list=new ArrayList<>();
		Thread t= new Thread() {
			public void run() {
				//InterThreadCommTest test=new InterThreadCommTest();
				test.waitt(list);
				//test.notifyTest();
			}
		};
		t.start();
		
		Thread t1= new Thread() {
			public void run() {
				//InterThreadCommTest test=new InterThreadCommTest();
				test.notifyTest(list);
			}
		};
		t1.start();
		
		
		
	}
	
	public synchronized void waitt(List<String> list) {
		list.add("1");
		list.add("2");
		
		if(list.size()==2) {
			try {
				System.out.println(list);
				list.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.add("3");
		System.out.println(list);
	}
	
	public synchronized void notifyTest(List<String> list) {
		for(String res:list) {
			if(res.equals("2")) {
				
				list.notify();
			}
			System.out.println(res);
		}
		
	}
}
