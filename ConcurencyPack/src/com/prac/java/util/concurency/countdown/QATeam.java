package com.prac.java.util.concurency.countdown;

public class QATeam extends Thread {
	
	public QATeam(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("Task assigned to "+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Task finished by "+Thread.currentThread().getName());
	}
}