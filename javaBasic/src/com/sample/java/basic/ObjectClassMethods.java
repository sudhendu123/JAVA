package com.sample.java.basic;

public class ObjectClassMethods implements Cloneable{

	private int age;
	public static void main(String[] args) {
		//returns the Class class object of this object. 
		//The Class class can further be used to get the metadata of this class.
		ObjectClassMethods obj=new ObjectClassMethods();
		System.out.println("getClass() :"+obj.getClass()+" object:"+obj);
		
		try {
			//creates and returns the exact copy (clone) of this object.
			Object obj1=obj.clone();
			System.out.println(" obj1 :"+obj1);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	//returns the string representation of this object.
	@Override
	public String toString() {
		return "ObjectClassMethods [age=" + age + "]";
	}
	
	//public int hashCode(),returns the hashcode number for this object.
	//public boolean equals(Object obj),compares the given object to this object.
	//public final void notify(),wakes up single thread, waiting on this object's monitor.
	//public final void notifyAll(),wakes up all the threads, waiting on this object's monitor.
	//public final void wait(long timeout)throws InterruptedException,causes the current thread to wait for the specified milliseconds, until another thread notifies (invokes notify() or notifyAll() method).
	//public final void wait(long timeout,int nanos)throws InterruptedException,causes the current thread to wait for the specified milliseconds and nanoseconds, until another thread notifies (invokes notify() or notifyAll() method).
	//public final void wait()throws InterruptedException,causes the current thread to wait, until another thread notifies (invokes notify() or notifyAll() method).
	//protected void finalize()throws Throwable,is invoked by the garbage collector before object is being garbage collected.
	
	
}
