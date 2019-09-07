package com.prac.java.util.concurency.countdown;

import java.util.concurrent.CountDownLatch;


public class AssignTaskManagerTest {
	public static void main(String[] args) throws InterruptedException {
		//Created CountDownLatch for 2 threads
		CountDownLatch countDownLatch = new CountDownLatch(2);
		
		//Created and started two threads
		DevTeam teamDevA = new DevTeam(countDownLatch, "dev-A");
		DevTeam teamDevB = new DevTeam(countDownLatch, "dev-B");
		
		teamDevA.start();
		teamDevB.start();
		
		//When two threads(dev-A and dev-B)completed tasks are returned
		countDownLatch.await();
		
		//Now execution of thread(QA team) started..
		QATeam qaTeam = new QATeam("QA team");
		qaTeam.start();
	}
}