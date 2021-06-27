package com.prac.java.util.concurency.thread.group;

public class ThreadGroupListExp {

	 public static void main(String[] args) {
		   ThreadGroupListDemo tg = new ThreadGroupListDemo();
	      tg.func();
	   }
}


class ThreadGroupListDemo implements Runnable {
	  

	   public void func() {
	      try {     
	         // create a parent ThreadGroup
	         ThreadGroup pGroup = new ThreadGroup("Parent ThreadGroup");
	    
	         // create a child ThreadGroup for parent ThreadGroup
	         ThreadGroup cGroup = new ThreadGroup(pGroup, "Child ThreadGroup");

	         // create a thread
	         Thread t1 = new Thread(pGroup, this);
	         System.out.println("Starting " + t1.getName() + "...");
	         t1.start();
	            
	         // create another thread
	         Thread t2 = new Thread(cGroup, this);
	         System.out.println("Starting " + t2.getName() + "...");
	         t2.start();
	             
	         // listing contents of parent ThreadGroup
	         System.out.println("\nListing parentThreadGroup: " + pGroup.getName() + ":");
	         // prints information about this thread group to the standard output
	         pGroup.list();

	         // listing contents of child ThreadGroup
	         System.out.println("\nListing childThreadGroup : " + cGroup.getName() + ":");
	         // prints information about this thread group to the standard output
	         //This method prints information about the thread group to the standard output.
	         cGroup.list();

	         // block until the other threads finish
	         t1.join();
	         t2.join();
	      } catch (InterruptedException ex) {
	         System.out.println(ex.toString());
	      }
	   }

	   // implements run()
	   public void run() {

	      for(int i = 0;i < 1000;i++) {
	         i++;
	      }
	      System.out.println(Thread.currentThread().getName() + " finished executing.");
	   }
	}  