package com.sample.java.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sudhendu.kumar
 *
 
class A { }
class B extends A { }
class C extends B { }
List<? extends T> - reading and assigning:

|-------------------------|-------------------|---------------------------------|
|         wildcard        |        get        |              assign             |
|-------------------------|-------------------|---------------------------------|
|    List<? extends C>    |    A    B    C    |   List<C>                       |
|-------------------------|-------------------|---------------------------------|
|    List<? extends B>    |    A    B         |   List<B>   List<C>             |
|-------------------------|-------------------|---------------------------------|
|    List<? extends A>    |    A              |   List<A>   List<B>   List<C>   |
|-------------------------|-------------------|---------------------------------|
List<? super T> - writing and assigning:

|-------------------------|-------------------|-------------------------------------------|
|         wildcard        |        add        |                   assign                  |
|-------------------------|-------------------|-------------------------------------------|
|     List<? super C>     |    C              |  List<Object>  List<A>  List<B>  List<C>  |
|-------------------------|-------------------|-------------------------------------------|
|     List<? super B>     |    B    C         |  List<Object>  List<A>  List<B>           |
|-------------------------|-------------------|-------------------------------------------|
|     List<? super A>     |    A    B    C    |  List<Object>  List<A>                    |
|-------------------------|-------------------|-------------------------------------------|
 *
O > S > T > U > V
Correct:

List<? extends T> Object = new List<T>();
List<? extends T> Object = new List<U>();
List<? extends T> Object = new List<V>();

List<? super T> Object = new List<T>();
List<? super T> Object = new List<S>();
List<? super T> Object = new List<O>();

List<? extends A> means this will accept any List of A and subclass of A. But you cannot add anything to this list. Not even objects of type A.

List<? super A> means this will accept any list of A and superclass of A. You can add objects of type A and its subclasses.

The Get and Put Principle
- When should we use the extends wildcard?
- When should we use the super wildcard?
- Where is it inappropriate to use a wildcard at all?
This principle states that:
Use an extends wildcard when you only get values out of a structure.
Use a super wildcard when you only put values into a structure.
And don’t use a wildcard when you both get and put.

And there are two exceptions:
You cannot put anything into a type declared with an extends wildcard except for the value null, which belongs to every reference type.
You cannot get anything out from a type declared with a super wildcard except for a value of type Object, which is a super type of every reference type.
 *
 */

public class GenericExample {

	public static void main(String[] args) {
		MyGen<Integer, String> m = new MyGen<Integer, String>();
		m.add(2);
		System.out.println(m.get());

		Integer[] intArray = { 10, 20, 30, 40, 50 };
		Character[] charArray = { 'J', 'A', 'V', 'A', 'T', 'P', 'O', 'I', 'N', 'T' };

		System.out.println("Printing Integer Array");
		printArray(intArray);

		System.out.println("Printing Character Array");
		printArray(charArray);

		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));

		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

		System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
				maximum("pear", "apple", "orange"));
		
		A aa=new A(1);
		B bb=new B("1");
		C cc=new C(2);
		List<? extends A> listb=new ArrayList<B>();
		List<? super B> listbb=new ArrayList<B>();
		listbb.add(cc);
		
	}

	public static <E> void printArray(E[] elements) {
		for (E element : elements) {
			System.out.println(element);
		}
		System.out.println();
	}

	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x; // assume x is initially the largest

		if (y.compareTo(max) > 0) {
			max = y; // y is the largest so far
		}

		if (z.compareTo(max) > 0) {
			max = z; // z is the largest now
		}
		return max; // returns the largest object
	}
}

class MyGen<T, U> {
	T obj;
	U obj1;

	void add(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}

class A {
	int a;

	public A() {}
	public A(int a) {
		super();
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}

class B extends A{
	public B() {}
	String b;

	public B(String b) {
		super();
		this.b = b;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

}

class C extends B{
	public C() {}
	float c;

	public C(float c) {
		super();
		this.c = c;
	}

	public float getC() {
		return c;
	}

	public void setC(float c) {
		this.c = c;
	}

	
}