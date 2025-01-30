package com.sample.java.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Declare the class as final so it cannot be subclassed.
Make all fields private and final to ensure they are not modified after initialization.
Provide a constructor to initialize all fields.
Do not provide setter methods.
If the class has mutable fields, ensure they are not directly accessible and return copies of them in getter methods.
 *
 */
public class ImmutableClass {
	public static void main(String[] args) {

		// String is the most popular immutable class in Java.
		// Once initialized its value cannot be modified.
		// Operations like trim(), substring(), replace() always return a new instance
		// and don’t affect the current instance
		String alex = "Alex ";
		System.out.println(alex.hashCode());
		alex = alex.trim();
		System.out.println(alex.hashCode());

		// Integer, Float, Boolean … these classes don’t modify their state,
		// however they create a new instance each time you try to modify them.
		Integer a = 3;
		System.out.println(a.hashCode());
		a += 3;
		System.out.println(a.hashCode());
		
		
		//Immutable class with mutable object age
		Age age = new Age();
	    age.setDay(1);
	    age.setMonth(1);
	    age.setYear(1992);
	    ImmutableClassWithMuttableObjAge imt = new ImmutableClassWithMuttableObjAge(1, "ram", age);
	    System.out.println("ram age year before modification = " + imt.getAge().getYear());
	    //ram age year before modification = 1992
	    //changing the value of age
	    age.setYear(1993);
	    System.out.println("ram age year after modification = " + imt.getAge().getYear());
	    //ram age year after modification = 1993
	    
	    System.out.println("========immutable age obj=============");
	    //Immutable class with mutable object age
	    Age age1 = new Age();
	    age1.setDay(1);
	    age1.setMonth(1);
	    age1.setYear(1992);
	    ImmutableClassObjAge imt1 = new ImmutableClassObjAge(1, "ram", age1);
	    System.out.println("ram age year before modification = " + imt1.getAge().getYear());
	    //ram age year before modification = 1992
	    System.out.println("before modification object"+imt1);
	    //before modification objectImmutableClassObjAge [id=1, name=ram, age=Age [day=1, month=1, year=1992]]
	    //changing the value of age
	    age1.setYear(1993);
	    System.out.println("ram age year after modification to 1993= " + imt1.getAge().getYear());
	    //ram age year after modification to 1993= 1992
	    System.out.println("after modification object"+imt1);
	    //after modification objectImmutableClassObjAge [id=1, name=ram, age=Age [day=1, month=1, year=1992]]
	    
	    //changing the value of age
	    imt1.getAge().setYear(1994);
	    System.out.println("ram age year after modification to 1994 = " + imt1.getAge().getYear());
	    //ram age year after modification to 1994 = 1994
	    System.out.println("after modification object"+imt1);
	    //after modification objectImmutableClassObjAge [id=1, name=ram, age=Age [day=1, month=1, year=1994]]
	    
	    System.out.println("========complete immutable=============");
		
	    Age age2 = new Age();
	    age2.setDay(1);
	    age2.setMonth(1);
	    age2.setYear(1992);
	    List<String> course=new ArrayList<String>();
	    course.add("EC");
	    CompleteImmutableClassObjAge imt2 = new CompleteImmutableClassObjAge(1, "ram", age2,course);
	    System.out.println("ram age year before modification = " + imt2.getAge().getYear());
	    //ram age year before modification = 1992
	    System.out.println("before modification object"+imt2);
	    //before modification objectImmutableClassObjAge [id=1, name=ram, age=Age [day=1, month=1, year=1992]]
	    //changing the value of age
	    age2.setYear(1993);
	    System.out.println("ram age year after modification to 1993= " + imt2.getAge().getYear());
	    //ram age year after modification to 1993= 1992
	    System.out.println("after modification object"+imt2);
	    //after modification objectImmutableClassObjAge [id=1, name=ram, age=Age [day=1, month=1, year=1992]]
	    
	    //changing the value of age
	    imt2.getAge().setYear(1994);
	    System.out.println("ram age year after modification to 1994 = " + imt2.getAge().getYear());
	    //ram age year after modification to 1994 = 1992
	    System.out.println("after modification object"+imt2);
	    //after modification objectImmutableClassObjAge [id=1, name=ram, age=Age [day=1, month=1, year=1992]]
		
	}

}

final class ImmutableClassWithMuttableObjAge {
	private final int id;
	private final String name;
	private final Age age;

	public ImmutableClassWithMuttableObjAge(int id, String name, Age age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Age getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "ImmutableClassWithMuttableObjAge [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}

final class ImmutableClassObjAge {
	private final int id;
	private final String name;
	private final Age age;

	public ImmutableClassObjAge(int id, String name, Age age) {
		this.name = name;
		this.id = id;
		Age cloneAge = new Age();
	    cloneAge.setDay(age.getDay());
	    cloneAge.setMonth(age.getMonth());
	    cloneAge.setYear(age.getYear());
	    this.age = cloneAge;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Age getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "ImmutableClassObjAge [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}

final class CompleteImmutableClassObjAge {
	private final int id;
	private final String name;
	private final Age age;
	private final List<String> course;

	public CompleteImmutableClassObjAge(int id, String name, Age age,List<String> course) {
		this.name = name;
		this.id = id;
		Age cloneAge = new Age();
	    cloneAge.setDay(age.getDay());
	    cloneAge.setMonth(age.getMonth());
	    cloneAge.setYear(age.getYear());
	    this.age = cloneAge;
	    this.course = Collections.unmodifiableList(new ArrayList<>(course));
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Age getAge() {
		 	Age cloneAge = new Age();
		    cloneAge.setDay(this.age.getDay());
		    cloneAge.setMonth(this.age.getMonth());
		    cloneAge.setYear(this.age.getYear());
		    return cloneAge;
	}
	

    public List<String> getStrings() {
        return course;
    }

	@Override
	public String toString() {
		return "ImmutableClassObjAge [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}


class Age {
	private int day;
	private int month;
	private int year;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Age [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
	
}