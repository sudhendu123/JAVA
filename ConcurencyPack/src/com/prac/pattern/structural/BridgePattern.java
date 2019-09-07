package com.prac.pattern.structural;
/**
 * decouple the functional abstraction from the implementation so that the two can vary independently
 * The Bridge Pattern is also known as Handle or Body.
 * @author sudhendu.kumar
 *
 */
public class BridgePattern {

	public static void main(String[] args) {
		Vehicle vehicle1 = new Car(new Produce(), new Assemble());
		vehicle1.manufacture();
		Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
		vehicle2.manufacture();
	}
}

abstract class Vehicle {
	protected Workshop workShop1;
	protected Workshop workShop2;

	protected Vehicle(Workshop workShop1, Workshop workShop2) {
		this.workShop1 = workShop1;
		this.workShop2 = workShop2;
	}

	abstract public void manufacture();
}

class Car extends Vehicle {
	public Car(Workshop workShop1, Workshop workShop2) {
		super(workShop1, workShop2);
	}

	@Override
	public void manufacture() {
		System.out.print("Car ");
		workShop1.work();
		workShop2.work();
	}
}

class Bike extends Vehicle {
	public Bike(Workshop workShop1, Workshop workShop2) {
		super(workShop1, workShop2);
	}

	@Override
	public void manufacture() {
		System.out.print("Bike ");
		workShop1.work();
		workShop2.work();
	}
}

interface Workshop {
	abstract public void work();
}

// Concrete implementation 1 for bridge pattern 
class Produce implements Workshop {
	@Override
	public void work() {
		System.out.print("Produced");
	}
}

class Assemble implements Workshop {
	@Override
	public void work() {
		System.out.print(" And");
		System.out.println(" Assembled.");
	}
}

//Without Bridge Design Pattern

						//VEHICLE
					//		|
					//-----------------------		
					//|					|
				//	BUS					BIKE		
				//	|					|
//				-------------			--------------------
//				|			|				|				|
//			PRODUCE-BUS	ASSEMBLE-BUS	PRODUCE-BIKE	ASSEMBLE-BIKE


//With Bridge Design Pattern

//VEHICLE-----------------------------------WORKSHOP
//		|										|
//-----------------------			-------------------------	
//	|					|			|						|	
//	BUS					BIKE		PRODUCE				ASSEMBLE
