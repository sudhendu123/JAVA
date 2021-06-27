package com.prac.java.util.concurency.thread.group;

public class ThreadGroupActiveCountExp {

	public static void main(String arg[])  
    {  
        // creating the thread group  
        ThreadGroup tg1 = new ThreadGroup("parent thread group");  
  
        // creating the threads  
        NewThread t1 = new NewThread("Thread-1", tg1);  
        NewThread t2 = new NewThread("Thread-2", tg1);  
        NewThread t3 = new NewThread("Thread-3", tg1);  
          
        // this will call the run() method  
        t1.start();  
        t2.start();  
        t3.start();  
  
        // checking the number of active thread  
        //This method returns an estimate of the number of active threads in the thread group and its subgroups.
        System.out.println("Number of active thread: "+ tg1.activeCount());  
    }  
}
