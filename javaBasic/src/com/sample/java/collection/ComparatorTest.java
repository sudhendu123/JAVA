package com.sample.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {

	public static void main(String args[]) {

		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 23));
		al.add(new Student(106, "Ajay", 27));
		al.add(new Student(105, "Jai", 21));

		System.out.println("Sorting by Name");

		Collections.sort(al, new NameComparator());
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		System.out.println("Sorting by age");

		Collections.sort(al, new AgeComparator());
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		// Sorting elements on the basis of name
		Comparator<Student> cm1 = Comparator.comparing(Student::getName);
		Collections.sort(al, cm1);
		System.out.println("Sorting by Name");
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
		// Sorting elements on the basis of age
		Comparator<Student> cm2 = Comparator.comparing(Student::getAge);
		Collections.sort(al, cm2);
		System.out.println("Sorting by Age");
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
		al.add(new Student(104, null, 29));
		Comparator<Student> cm11 = Comparator.comparing(Student::getName, Comparator.nullsFirst(String::compareTo));
		Collections.sort(al, cm11);
		System.out.println("Considers null to be less than non-null");
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
		Comparator<Student> cm22 = Comparator.comparing(Student::getName, Comparator.nullsLast(String::compareTo));
		Collections.sort(al, cm22);
		System.out.println("Considers null to be greater than non-null");
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		ArrayList<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee(2, "Lokesh", "Gupta"));
		employeesList.add(new Employee(1, "Alex", "Gussin"));
		employeesList.add(new Employee(4, "Brian", "Sux"));
		employeesList.add(new Employee(5, "Neon", "Piper"));
		employeesList.add(new Employee(3, "David", "Beckham"));
		employeesList.add(new Employee(7, "Alex", "Beckham"));
		employeesList.add(new Employee(6, "Brian", "Suxena"));

		System.out.println("Compare by first name and then last name");
		Comparator<Employee> compareByName = Comparator.comparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName);

		Collections.sort(employeesList, compareByName);
		for(Employee emp:employeesList) {
			System.out.println("age:"+emp.getAge()+" fname:"+emp.getFirstName()+" lname:"+emp.getLastName());	
		}
		
	}
}

class AgeComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if (s1.age == s2.age)
			return 0;
		else if (s1.age > s2.age)
			return 1;
		else
			return -1;
	}
}

class NameComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.name.compareTo(s2.name);
	}
}

class Employee {
	int age;
	String firstName;
	String lastName;

	public Employee(int age, String firstName, String lastName) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
}