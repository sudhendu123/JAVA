package com.prac.java.util.concurency.synchonized;

public class StaticSynchronizedMethodTest {
	public StaticSynchronizedMethodTest() {

	}

	int a, b;

	public StaticSynchronizedMethodTest(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		// StaticSynchronizedMethodTest s=new StaticSynchronizedMethodTest(1,4);
		StaticSynchronizedMethodTest.add2(1, 4);
		Thread t = new Thread() {
			public void run() {
				// StaticSynchronizedMethodTest s=new StaticSynchronizedMethodTest(1,2);
				StaticSynchronizedMethodTest.add(1, 3);
			}
		};
		t.start();
		t.setName("t");

		Thread t1 = new Thread() {
			public void run() {
				// StaticSynchronizedMethodTest s=new StaticSynchronizedMethodTest(1,3);
				StaticSynchronizedMethodTest.add1(1, 2);
			}
		};
		t1.start();
		t1.setName("t1");
	}

	public static synchronized void add(int a, int b) {

		for (int i = 1; i <= 2; i++) {
			System.out.println(a + b + ":" + Thread.currentThread().getName());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}

	public static synchronized void add1(int a, int b) {
		for (int i = 1; i <= 2; i++) {
			System.out.println(a + b + ":" + Thread.currentThread().getName());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}

	public static synchronized void add2(int a, int b) {
		for (int i = 1; i <= 2; i++) {
			System.out.println(a + b + ":" + Thread.currentThread().getName());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}
}
