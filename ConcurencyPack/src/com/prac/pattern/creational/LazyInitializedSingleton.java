package com.prac.pattern.creational;

public class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {
	}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}

}

final class LazySingleton {
	private static volatile LazySingleton instance = null;

	// private constructor
	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				instance = new LazySingleton();
			}
		}
		return instance;
	}
}

class LazyInSingleton {
	private static volatile LazyInSingleton instance = null;

	// private constructor
	private LazyInSingleton() {
	}

	public static LazyInSingleton getInstance() {
		if (instance == null) {
			synchronized (LazyInSingleton.class) {
				// Double check
				if (instance == null) {
					instance = new LazyInSingleton();
				}
			}
		}
		return instance;
	}
}