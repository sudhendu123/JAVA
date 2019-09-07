package com.sample.java.stream;

interface Sayable1 {
	void say();
}
interface methodRef{
	void saying(String sa);
}
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
        
        methodRef out1 =MethodReference::new;
        out1.saying("hello");
	}
}
