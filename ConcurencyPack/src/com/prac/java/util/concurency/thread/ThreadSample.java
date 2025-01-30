package com.prac.java.util.concurency.thread;

import java.util.concurrent.TimeUnit;

public class ThreadSample  {


    public static void main(String[] args) {
		ThreadSample1 t=new ThreadSample1();
		Thread tt=new Thread(t);
		tt.start();
	}
}

class ThreadSample1 implements Runnable {


    public void run() {
        String methodName = "run()";
        while (true) {
            try {
                TimeUnit.MINUTES.sleep(1);
                System.out.println("start");
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}