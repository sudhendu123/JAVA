package com.prac.java.util.concurency.thread;

public class TestJoinMethod extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("thread :"+Thread.currentThread().getName()+" : "+i);
		}
	}

	public static void main(String args[]) {
		TestJoinMethod th1 = new TestJoinMethod();
		TestJoinMethod th2 = new TestJoinMethod();
		TestJoinMethod th3 = new TestJoinMethod();
		// Start first thread immediately
		th1.setPriority(Thread.MIN_PRIORITY);  
	      th1.start();
	      th1.setName("thread 0");   
	      /* Start second thread(th2) once first thread(th1) 
	       * is dead
	       */
	      try {
	          th1.join();
	      } catch (InterruptedException ie) {
	          ie.printStackTrace();
	        }
	      th2.start();
	         
	      /* Start third thread(th3) once second thread(th2) 
	       * is dead
	       */
	      try {
	          th2.join();
	      } catch (InterruptedException ie) {
	           ie.printStackTrace();
	        }
	      th3.start();
	         
	      // Displaying a message once third thread is dead
	      try {
	          th3.join();
	      } catch (InterruptedException ie) {
	            ie.printStackTrace();
	        }  
		
	}
}
/*
 * The join() method waits for a thread to die. In other words, it causes the
 * currently running threads to stop executing until the thread it joins with
 * completes its task.
 */