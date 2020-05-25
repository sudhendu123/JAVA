package com.sample.java.basic;

class Parent {
	public static void demoMethod() {
		System.out.println("method of super class");
	}
}

public class MethodHiding extends Parent {

	public static void demoMethod() {
		System.out.println("method of sub class");
	}

	public static void main(String args[]) {
		Parent.demoMethod();// method of super class
		MethodHiding.demoMethod();// method of sub class
		MethodHiding a = new MethodHiding();
		Parent b = new Parent();
		Parent c = new MethodHiding();
		a.demoMethod();// method of sub class
		b.demoMethod();// method of super class
		c.demoMethod();// method of super class
	}

}
