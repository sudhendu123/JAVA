package com.prac.java.util.concurency.countdown;

import java.util.concurrent.CountDownLatch;


public class AssignTaskManagerTest {
	public static void main(String[] args) throws InterruptedException {
		//Created CountDownLatch for 3 threads
		//the number 3(can be less than 3 but not more than 3) 
		//if countDown number is 4 then all the 3 thread will start and finish and wait for the 4th thread
		//As no 4th thread is present it will go to waiting state
		
		//when count down reaches 0 the wait is over and the other threads can start below await method
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		//Created and started two threads
		DevTeam teamDevA = new DevTeam(countDownLatch, "dev-A");
		DevTeam teamDevB = new DevTeam(countDownLatch, "dev-B");
		DevTeam teamDevC = new DevTeam(countDownLatch, "dev-C");
		
		teamDevA.start();
		teamDevB.start();
		teamDevC.start();
		
		//When two threads(dev-A and dev-B)completed tasks are returned
		countDownLatch.await();
		System.out.println("Done development");
		//Now execution of thread(QA team) started..
		QATeam qaTeam = new QATeam("QA team");
		qaTeam.start();
	}
}