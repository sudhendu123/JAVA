package com.prac.pattern.behavioral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		System.out.println("Enter Text >");

		// create an event source - reads from stdin
		final EventSource eventSource = new EventSource();

		// create first observer
		final ResponseHandler1 responseHandler1 = new ResponseHandler1();

		// subscribe the observer to the event source
		eventSource.addObserver(responseHandler1);

		// create second observer
		final ResponseHandler2 responseHandler2 = new ResponseHandler2();

		// subscribe the observer to the event source
		eventSource.addObserver(responseHandler2);

		// starts the event thread
		Thread thread = new Thread(eventSource);
		thread.start();
	}
}

class ResponseHandler1 implements Observer {
	private String resp;

	public void update(Observable obj, Object arg) {
		if (arg instanceof String) {
			resp = (String) arg;
			System.out.println("\nReceived Response: " + resp);
		}
	}
}

class EventSource extends Observable implements Runnable {
	@Override
	public void run() {
		try {
			final InputStreamReader isr = new InputStreamReader(System.in);
			final BufferedReader br = new BufferedReader(isr);
			while (true) {
				String response = br.readLine();
				setChanged();
				notifyObservers(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ResponseHandler2 implements Observer {
	private String resp;

	public void update(Observable obj, Object arg) {
		if (arg instanceof String) {
			resp = (String) arg;
			System.out.println("\nReceived Response: " + resp);
		}
	}
}
