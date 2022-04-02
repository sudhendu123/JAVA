package com.sample.java.innerclass;

public class AbstractAnonymousInner {

	public static void main(String args[]) {
		Person p = new Person() {
			void eat() {
				System.out.println("nice fruits");
			}

			@Override
			void sit() {
				System.out.println("sit");
			}
		};
		p.eat();
	}

}

abstract class Person {
	abstract void eat();
	abstract void sit();
}