package com.prac.java.util.concurency.synchonized;

public class StaticSynchronizedBlockTest {

	public StaticSynchronizedBlockTest() {

	}

	int a, b;

	public StaticSynchronizedBlockTest(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		// StaticSynchronizedBlockTest s=new StaticSynchronizedBlockTest(1,4);
		StaticSynchronizedBlockTest.add2(1, 4);
		Thread t = new Thread() {
			public void run() {
				// StaticSynchronizedBlockTest s=new StaticSynchronizedBlockTest(1,2);
				StaticSynchronizedBlockTest.add(1, 3);
			}
		};
		t.start();
		t.setName("t");

		Thread t1 = new Thread() {
			public void run() {
				// StaticSynchronizedBlockTest s=new StaticSynchronizedBlockTest(1,3);
				StaticSynchronizedBlockTest.add1(1, 2);
			}
		};
		t1.start();
		t1.setName("t1");
	}

	public static void add(int a, int b) {
		synchronized (StaticSynchronizedBlockTest.class) {
			for (int i = 1; i <= 2; i++) {
				System.out.println(a + b + ":" + Thread.currentThread().getName());
				try {
					Thread.sleep(400);
				} catch (Exception e) {
				}
			}
		}

	}

	public static synchronized void add1(int a, int b) {
		synchronized (StaticSynchronizedBlockTest.class) {
			for (int i = 1; i <= 2; i++) {
				System.out.println(a + b + ":" + Thread.currentThread().getName());
				try {
					Thread.sleep(400);
				} catch (Exception e) {
				}
			}
		}
	}

	public static synchronized void add2(int a, int b) {
		synchronized (StaticSynchronizedBlockTest.class) {
			for (int i = 1; i <= 2; i++) {
				System.out.println(a + b + i+":" + Thread.currentThread().getName());
				try {
					Thread.sleep(400);
				} catch (Exception e) {
				}
			}
		}
	}
}
