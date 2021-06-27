package com.prac.java.util.concurency.semaphor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest4 {

	
	 public static void main(String[] args) throws Exception {
	        ExecutorService executor = Executors.newCachedThreadPool();

	        for (int i = 0; i < 20; i++) { //200 hundred times will be called
	            executor.submit(new Runnable() {
	                public void run() {
	                    Connectionn.getInstance().connect();
	                }
	            });
	        }

	        executor.shutdown();
	        executor.awaitTermination(1, TimeUnit.DAYS);
	    }
	 
	 
}

class Connection1 {

    private static Connection1 instance = new Connection1();
/*
    limit connections to 10
    true means whichever thread gets first in the waiting pool (queue)
    waiting to acquire a resource, is first to obtain the permit.

    Note that I called it a pool!
    The reason is when you say "Queue", you're saying that things are
    scheduled to be FIFO (First In First Out) .. which is not always the case
    here!
    When you initialize the semaphore with Fairness, by setting its second
    argument to true, it will treat the waiting threads like FIFO.
    But,
    it doesn't have to be that way if you don't set on the fairness. the JVM
    may schedule the waiting threads in some other manner that it sees best
    (See the Java specifications for that).
*/
    private Semaphore sem = new Semaphore(10, true);
    private int connections = 0;

    private Connection1() {
    }

    public static Connection1 getInstance() {
        return instance;
    }

    public void connect() {
        try {

            // get permit decrease the sem value, if 0 wait for release
            sem.acquire();

            //if doConnect throws and exception is still releases the permit
            //so we use a separate method here to increase the connections count
            doConnect();

        } catch (InterruptedException ignored) {
        } finally {
            //release permit, increase the sem value and activate waiting thread
            sem.release();
        }
    }

    public void doConnect() {
        synchronized (this) { //atomic
            connections++;
            System.out.println("Current connections (max 10 allowed): " + connections);
        }
        try {
            //do your job
            System.out.println("Working on connections " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        //when exit doConnect method decrement number of connections
        synchronized (this) {//atomic
            connections--;
            System.out.println("I'm done " + Thread.currentThread().getName() + " Connection is released , connection count: " + connections);
        }
    }
}


class Connectionn {

    private static Connectionn instance = new Connectionn();
    /*
        limit connections to 10
        true means whichever thread gets first in the waiting pool (queue)
        waiting to acquire a resource, is first to obtain the permit.

        Note that I called it a pool!
        The reason is when you say "Queue", you're saying that things are
        scheduled to be FIFO (First In First Out) .. which is not always the case
        here!
        When you initialize the semaphore with Fairness, by setting its second
        argument to true, it will treat the waiting threads like FIFO.
        But,
        it doesn't have to be that way if you don't set on the fairness. the JVM
        may schedule the waiting threads in some other manner that it sees best
        (See the Java specifications for that).
    */
    private Semaphore sem = new Semaphore(10, true);

    private Connectionn() {
    }

    public static Connectionn getInstance() {
        return instance;
    }

    public void connect() {
        try {

            // get permit decrease the sem value, if 0 wait for release
            sem.acquire();

            System.out.printf("%s:: Current connections (max 10 allowed): %d\n",
                    Thread.currentThread().getName(),
                    sem.availablePermits());

            //do your job
            System.out.printf("%s:: WORKING...\n",
                    Thread.currentThread().getName());
            Thread.sleep(2000);

            System.out.printf("%s:: Connection released. Permits Left = %d\n",
                    Thread.currentThread().getName(),
                    sem.availablePermits());

        } catch (InterruptedException ignored) {
        } finally {
            //release permit, increase the sem value and activate waiting thread
            sem.release();
        }
    }
}
