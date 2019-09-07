package com.prac.pattern.structural;

public class DecoratorPatternTest {
	public static void main(String[] args) {
		Carr sportsCarr = new SportsCarr(new BasicCarr());
		sportsCarr.assemble();
		System.out.println("\n*****");

		Carr sportsLuxuryCarr = new SportsCarr(new LuxuryCarr(new BasicCarr()));
		sportsLuxuryCarr.assemble();
	}

}

class LuxuryCarr extends CarrDecorator {

	public LuxuryCarr(Carr c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Luxury Carr.");
	}
}

class SportsCarr extends CarrDecorator {

	public SportsCarr(Carr c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Sports Carr.");
	}
}

class CarrDecorator implements Carr {

	protected Carr Carr;

	public CarrDecorator(Carr c) {
		this.Carr = c;
	}

	@Override
	public void assemble() {
		this.Carr.assemble();
	}

}

class BasicCarr implements Carr {

	@Override
	public void assemble() {
		System.out.print("Basic Carr.");
	}

}

interface Carr {

	public void assemble();
}


				//car
				//|
			//Basic car
			//	|
			//-----------------
//				|			|
	//		sprots car 	lux car	