package com.prac.java.util.concurency.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable {
	
	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();

		ExchangerRunnableTest exchangerRunnable1 =
		        new ExchangerRunnableTest(exchanger, "A");

		ExchangerRunnableTest exchangerRunnable2 =
		        new ExchangerRunnableTest(exchanger, "B");

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
	}
	
}
class ExchangerRunnableTest implements Runnable{

    Exchanger exchanger = null;
    Object    object    = null;

    public ExchangerRunnableTest(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    public void run() {
        try {
            Object previous = this.object;

            this.object = this.exchanger.exchange(this.object);

            System.out.println(
                    Thread.currentThread().getName() +
                    " exchanged " + previous + " for " + this.object
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}