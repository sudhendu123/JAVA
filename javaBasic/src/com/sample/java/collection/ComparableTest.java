package com.sample.java.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableTest {
	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 23));
		al.add(new Student(106, "Ajay", 27));
		al.add(new Student(105, "Jai", 21));

		Collections.sort(al);
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
		
		System.out.println("revers order");
		Collections.sort(al,Collections.reverseOrder());
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
	}
}

class Student implements Comparable<Student> {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
/**
	public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
	}
**/
	// reverse order
	/**
	  public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		else if (age < st.age)
			return 1;
		else
			return -1;
	}
	**/
	/**
	public int compareTo(Student st){
	     int last = this.name.compareTo(st.name);
	     return last == 0 ? this.name.compareTo(st.name) : last;
	  }
	  **/
	
	@Override
    public int compareTo(Student st) {
        return (this.age - st.age);
    }
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}