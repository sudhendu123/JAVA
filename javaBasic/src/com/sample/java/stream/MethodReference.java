package com.sample.java.stream;

import java.util.function.BiFunction;

interface Sayable1 {
	void say();
}
interface MethodRefIntf{
	void saying(String sa);
}
/*
 * Method reference is used to refer method of functional interface.
 * It is compact and easy form of lambda expression.
 * Types of Method References
 	1.Reference to a static method.
	2.Reference to an instance method.
	3.Reference to a constructor.
 */
public class MethodReference {
	
	public MethodReference() {};
	
	public MethodReference(String msg) {
		System.out.println(msg);
	};
	
	 public static void ThreadStatus(){  
	        System.out.println("Thread is running...");  
	    } 
	 
	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}
	
	public void saySomething1() {
		System.out.println("Hello, this is static method.");
	}

	public static void main(String[] args) {
		// Referring static method
		Sayable1 sayable = MethodReference::saySomething;
		// Calling interface method
		sayable.say();
		
		Thread t2=new Thread(MethodReference::ThreadStatus);  
        t2.start();  

        //Reference to an Instance Method
        MethodReference md=new MethodReference();
        Sayable1 out = md::saySomething1;
        out.say();
        
        //Reference to a constructor.
        MethodRefIntf out1 =MethodReference::new;
        out1.saying("hello");
	}
}
//==============================================================================
//containingObject::instanceMethodName  
interface InstanceSayable {
	void say();
}

class InstanceMethodReference {
	public void saySomething() {
		System.out.println("Hello, this is non-static method.");
		
	}

	public void saySomething1() {
		System.out.println("Hello, this is non-static method1.");
		
	}
	
	public static void main(String[] args) {
		InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object
		// Referring non-static method using reference
		InstanceSayable sayable = methodReference::saySomething;
		// Calling interface method
		sayable.say();
		// Referring non-static method using anonymous object
		InstanceSayable sayable2 = new InstanceMethodReference()::saySomething1; // You can use anonymous object also
		// Calling interface method
		sayable2.say();
	}
}

class InstanceMethodReference2 {
	public void printnMsg() {
		System.out.println("Hello, this is instance method");
	}

	public static void main(String[] args) {
		Thread t2 = new Thread(new InstanceMethodReference2()::printnMsg);
		t2.start();
	}
}

class Arithmetic {
	public int add(int a, int b) {
		return a + b;
	}
}

class InstanceMethodReference3 {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> adder = new Arithmetic()::add;
		int result = adder.apply(10, 20);
		System.out.println(result);
	}
}

//3) Reference to a Constructor
//ClassName::new  

interface Messageable {
	Message getMessage(String msg);
}

class Message {
	Message(String msg) {
		System.out.print(msg);
	}
}

class ConstructorReference {
	public static void main(String[] args) {
		Messageable hello = Message::new;
		hello.getMessage("Hello");
	}
}

