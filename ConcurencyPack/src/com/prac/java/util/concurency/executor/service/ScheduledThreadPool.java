package com.prac.java.util.concurency.executor.service;



import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ScheduledThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		
		
		//schedule to run after sometime
		System.out.println("Current Time = "+new Date());
		for(int i=0; i<3; i++){
			Thread.sleep(1000);
			WorkerThread2 worker = new WorkerThread2("do heavy processing");
			//task to run after 10 sec delay
			//scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
			//task to run repetedly every 10 sec
			//scheduledThreadPool.scheduleAtFixedRate(worker, 0, 10,TimeUnit.SECONDS);
			//task to run repeatedly 10 sec after previous task complete.
			scheduledThreadPool.scheduleWithFixedDelay(worker, 0, 1,TimeUnit.SECONDS);
		}
		
		//add some delay to let some threads spawn by scheduler
		Thread.sleep(30000);
		
		scheduledThreadPool.shutdown();
		while(!scheduledThreadPool.isTerminated()){
			//wait for all tasks to finish
		}
		System.out.println("Finished all threads");
	}

}

class WorkerThread2 implements Runnable{

private String command;
    
    public WorkerThread2(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
