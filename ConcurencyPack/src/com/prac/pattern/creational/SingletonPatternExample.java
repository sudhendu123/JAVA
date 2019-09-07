package com.prac.pattern.creational;

//Lazily Initialized Inner Class Singleton (Bill Pugh singleton)
public class SingletonPatternExample {
	
	public static void main(String[] args) {
		BillPughSingletonClass singleton = BillPughSingletonClass.getInstance();
		singleton.utilMetod(20);
	}

	
}

/**
 * Note that, the inner class is not loaded until the getInstance()
 *  method is invoked for the first time. This solution is thread-safe and doesn’t 
 *  require any synchronization. It is the most efficient approach among all
 *   the singleton design pattern implementations.
 */ 

class BillPughSingletonClass{
private BillPughSingletonClass() {}
	int a=10;
	// Inner class to provide instance of class 
	  private static class BillPughSingleton 
	  { 
		  private static final BillPughSingletonClass single=new BillPughSingletonClass();
	  }
	  
	  public static BillPughSingletonClass getInstance() {
		  return BillPughSingleton.single;
	  }
	  
	  protected void utilMetod(int a) {
		  System.out.println("a: "+a);
	  }
}