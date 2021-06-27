package com.prac.java.util.concurency.thread;

import java.io.IOException;

public class CSThreadInterrupt {
	public static void main(String [] args) {
        Thread thread = new Thread(new WaitingForUserInput());
        thread.setName("InputWaitingThread");
        //The only way to programmatically stop the application is to make the thread a daemon.
        //Unfortunately System.in.read() does not respond to Thread.interrupt();
        //thread.setDaemon(true);
        thread.start();
        
    }
 
    private static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read();
                    if(input == 'x') {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            };
        }
    }

}
