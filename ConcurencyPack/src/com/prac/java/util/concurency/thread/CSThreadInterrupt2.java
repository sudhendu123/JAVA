package com.prac.java.util.concurency.thread;

public class CSThreadInterrupt2 {
	
	public static void main(String [] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
        //interrupt() is not called then thread will be in sleep 
        //thread.interrupt();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            //do things
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Existing blocking thread");
            }
        }
    }

}
