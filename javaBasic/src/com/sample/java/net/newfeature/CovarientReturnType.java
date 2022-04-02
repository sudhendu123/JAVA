package com.sample.java.net.newfeature;

public class CovarientReturnType {
	
	public static void main(String args[]) {
		new B1().get().message();
	}

}

class A {
	A get() {
		return this;
	}
}

class B1 extends A {
	@Override
	B1 get() {
		return this;
	}

	void message() {
		System.out.println("welcome to covariant return type");
	}

}