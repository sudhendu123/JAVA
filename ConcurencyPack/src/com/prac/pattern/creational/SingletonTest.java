package com.prac.pattern.creational;

//The Singleton pattern ensures that a class has only one instance and provides a global point of access to it. 
public class SingletonTest {

	 public static void main(String[] args) {
	        // Get the only object available
	        Singleton singleton = Singleton.getInstance();

	        // Show the message
	        singleton.showMessage();
	    }
	
}

class Singleton {
   
    
 // Private static variable of the same class that is the only instance of the class
    private static Singleton singleInstance = null;

    // Private constructor to restrict instantiation of the class from other classes
    private Singleton() {
        // Initialization code here
    }

    // Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class
    public static Singleton getInstance() {
        if (singleInstance == null) {
            synchronized (Singleton.class) {
                if (singleInstance == null) {
                    singleInstance = new Singleton();
                }
            }
        }
        return singleInstance;
    }

    // Other methods of the class
    public void showMessage() {
        System.out.println("Hello World!");
    }
}