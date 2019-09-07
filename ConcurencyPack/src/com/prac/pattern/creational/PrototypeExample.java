package com.prac.pattern.creational;

/**
 * Prototype Pattern says that cloning of an existing object instead of creating
 * new one and can also be customized as per the requirement.
 * 
 * @author sudhendu.kumar
 *
 */
public class PrototypeExample {
	public static void main(String[] args) {
		proto ex=new proto(1,"name","desg",123,"address");
		ex.showRecord();
		System.out.println();
		proto clone = ex.getClone();
		clone.showRecord();
	}
}

class proto implements Prototype {

	private int id;
	private String name, designation;
	private double salary;
	private String address;

	public proto() {

	}

	public proto(int id, String name, String designation, double salary, String address) {

		this();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
	}

	public void showRecord() {

		System.out.println(id + "\t" + name + "\t" + designation + "\t" + salary + "\t" + address);
	}

	@Override
	public proto getClone() {

		return new proto(id, name, designation, salary, address);
	}
}


interface Prototype {

	public Prototype getClone();

}