package com.prac.java.util.concurency.thread;

public class CSThreadInterrupt1 {

	 public static void main(String [] args) {
	        Thread thread = new Thread(new SleepingThread());
	        thread.start();
	        thread.interrupt();
	    }
	 
	    private static class SleepingThread implements Runnable {
	        @Override
	        public void run() {
	            while (true) {
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                	System.out.println(" InterruptedException,then also thread is running ");
	                	//to stop the thread uncomment the return statement.
	                	return;
	                }
	            }
	        }
	    }
}
