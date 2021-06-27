package com.prac.java.util.concurency.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExceptionTest {
	public static void main(String[] args) {
		
		Monitor asyncFwJobMonitor =  new Monitor();
		ScheduledExecutorService asyncSerevice = Executors.newScheduledThreadPool(1, new TestThreadFactory("Monitor"));
		asyncSerevice.scheduleAtFixedRate(asyncFwJobMonitor, 5, 5, TimeUnit.SECONDS);
	}
	
	

}

class Monitor implements Runnable{

	@Override
	public void run() {
		AtomicInteger at=new AtomicInteger();
		//try {
			System.out.println("System.currentTimeMillis() :"+System.currentTimeMillis());
			System.out.println("running: "+TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
			System.out.println("Count :"+at.get());
			//if(at.get()<2) {
				//throw new RuntimeException();
				int a=1/0;
			//}
			
		/**}catch (Throwable e) {
			at.incrementAndGet();
			System.out.println("Count1 :"+at.get());
			e.printStackTrace();
		}*/
		
		
	}
	
}

class TestThreadFactory implements ThreadFactory {

	   // private final ThreadGroup group;
	    private final AtomicInteger threadNumber = new AtomicInteger(1);
	    private final String namePrefix;

	    public TestThreadFactory(String threadPrefix) {
	        SecurityManager securityManager = System.getSecurityManager();
	       /* group = (securityManager != null) ? securityManager.getThreadGroup() :
	                Thread.currentThread().getThreadGroup();*/
	        namePrefix = threadPrefix;
	    }

	    public Thread newThread(Runnable r) {
	        Thread thread = new Thread(null, r, namePrefix + "-" + threadNumber.getAndIncrement(), 0);
	        if (thread.isDaemon())
	            thread.setDaemon(false);
	        if (thread.getPriority() != Thread.NORM_PRIORITY)
	            thread.setPriority(Thread.NORM_PRIORITY);
	        return thread;

	    }

	}
