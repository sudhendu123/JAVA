package com.prac.pattern.structural;

/**
 * 
 * @author sudhendu.kumar
 *  Decorator pattern allows a user to add new
 *         functionality to an existing object without altering its structure.
 *         To extend or modify the behaviour of ‘an instance’ at runtime
 *         decorator design pattern is used. Is used to modify the functionality
 *         of an object at runtime. At the same time other instances of the same
 *         class will not be affected by this, so individual object gets the
 *         modified behavior.
 */
public class DecoratorPattern {

	public static void main(String args[]) {
		Icecream icecream = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
		System.out.println(icecream.makeIcecream());
	}
}

class HoneyDecorator extends IcecreamDecorator {

	public HoneyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addHoney();
	}

	private String addHoney() {
		return " + sweet honey";
	}
}

class NuttyDecorator extends IcecreamDecorator {

	public NuttyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addNuts();
	}

	private String addNuts() {
		return " + cruncy nuts";
	}
}

abstract class IcecreamDecorator implements Icecream {

	protected Icecream specialIcecream;

	public IcecreamDecorator(Icecream specialIcecream) {
		this.specialIcecream = specialIcecream;
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream();
	}
}

class SimpleIcecream implements Icecream {

	@Override
	public String makeIcecream() {
		return "Base Icecream";
	}

}

interface Icecream {
	public String makeIcecream();
}
