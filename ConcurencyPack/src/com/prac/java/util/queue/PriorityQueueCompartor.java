package com.prac.java.util.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueCompartor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Creating Priority queue constructor having
		// initial capacity=3 and a StudentComparator instance
		// as its parameters
		PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new NameComparator());
		//PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentCGPAComparator());

		// Invoking a parameterized Student constructor with
		// name and cgpa as the elements of queue
		Student student1 = new Student("N", 2);
		Student student2 = new Student("A", 6);
		Student student3 = new Student("P", 4);
		Student student4 = new Student("Z", 9);
		// Adding a student object containing fields
		// name and cgpa to priority queue
		pq.add(student1);
		pq.add(student4);
		pq.add(student2);
		pq.add(student3);
		

		// Printing names of students in priority order,poll()
		// method is used to access the head element of queue
		System.out.println("Students served in their priority order");
		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq);
		/*while (!pq.isEmpty()) {
			System.out.println(pq.poll().getName());
		}*/
		
		/*for(Student stu:pq) {
			System.out.println(stu.getName() +":"+stu.getCgpa());
		}*/
	}
}

class StudentCGPAComparator implements Comparator<Student> {

	// Overriding compare()method of Comparator
	// for descending order of cgpa
	public int compare(Student s1, Student s2) {
		/*if (s1.cgpa < s2.cgpa)
			return 1;
		else if (s1.cgpa > s2.cgpa)
			return -1;
		return 0;*/
		
		if(s1.cgpa==s2.cgpa)  
			return 0;  
			else if(s1.cgpa>s2.cgpa)  
			return 1;  
			else  
			return -1;  
	}
}


class NameComparator implements Comparator<Student>{  
public int compare(Student s1,Student s2){  
return s1.name.compareTo(s2.name);  
}  
}  

class Student {
	public String name;
	public double cgpa;

	// A parameterized student constructor
	public Student(String name, double cgpa) {

		this.name = name;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", cgpa=" + cgpa + "]";
	}
	
}
