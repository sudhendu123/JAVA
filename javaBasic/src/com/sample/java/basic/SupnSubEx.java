package com.sample.java.basic;

public class SupnSubEx {

public static void main(String[] args) {
		
		
		
		//P=P We can access only parent methods.
		/*s w =new s();
		w.m1(); we can access only m1()but if we override the m1() in sub class then also super m1() will be called
		o/p in m1*/
		//c=c we can access all parent and child methods. 
		/*ss q=new ss();
		q.m1();
		q.m2(); we can acess both methods of sub class if we override the supper class m1() in ss then 
		value of sub m1() will print,if we r not overRIDING  m1() then superclass m1() will print.
		o/p in m21 in m2 */
		
		//Upcasting
		//p=c
		// in this we are having access to A class method only because the of reference is A, 
		//So what all fields or methods A have we can see those type only. Like in "int" type we cannot add anything other than "int" type  
		/*s w=new ss();//dynamic dispatch
		w.m1();   we can access only m1() but if we override the m1() in subclass then sub class m1() will give o/p
		o/p in m21*/
		
		//downcasting Error
		//CHILD is-a PARENT, but PARENT is not a CHILD.
		//You can only assign an object to an instance of itself or it's super classes, not it's subclasses.
		//c=p
		/*ss n = new s(); here compile error will come
		ss n =(ss) new s(); here complie error will not come but class cast exception will come
		
		n.m1();
		n.m2();
		this gives an class cast exception
		*/
		
		//downcasting Solution
		/*s q=new ss();this is the solution of the 1st
		ss w=(ss)q;
		w.m1(); if we not overriding the m1() in sub class then we will get super class m1() o/p 
		w.m2();
		o/p in m21 in m2*/
		
		
	}

}

class s {

	public void m1() {
		System.out.println("in m1");
	}
}

class ss extends s {

	public void m2() {
		System.out.println("in m2");
	}

	/*
	 * public void m1(){ System.out.println("in m21"); }
	 */
}
