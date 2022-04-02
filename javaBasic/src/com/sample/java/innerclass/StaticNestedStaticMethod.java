package com.sample.java.innerclass;

public class StaticNestedStaticMethod {

	static int data = 30;

	static class Inner {
		static void msg() {
			System.out.println("data is " + data);
		}
	}

	public static void main(String args[]) {
		StaticNestedStaticMethod.Inner.msg();// no need to create the instance of static nested class
	}
}
