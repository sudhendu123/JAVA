package com.sample.java.collection;

import java.util.concurrent.CopyOnWriteArraySet;

//Set that uses an internal CopyOnWriteArrayList for all of its operations.
public class CopyOnWriteArraySetTest {
	public static void main(String[] args) {
		CopyOnWriteArraySet<String> l = new CopyOnWriteArraySet<>();
		l.add("a");
		l.add("b");
	}

}
