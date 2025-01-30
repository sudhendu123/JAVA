package com.sample.java.collection;

import java.util.HashSet;
import java.util.Objects;

public class HashCodeTest {
	
	public static void main(String[] args) {
		
		Emp e1=new Emp("Ram",1);
		Emp e2=new Emp("Ram",1);
		Emp e3=new Emp("shyama",3);
		
		HashSet<Emp> emp1=new HashSet<>();
		emp1.add(e1);
		emp1.add(e2);
		emp1.add(e3);
		
		System.out.println(emp1.size()); //3
		//Emp e2=new Emp("Ram",1); if this is set then size will 2 as we ovverride hashcode same object will refrenced.
	}

}

class Emp{
	
	String name;
	int id;
	public Emp(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	
	
	
}
