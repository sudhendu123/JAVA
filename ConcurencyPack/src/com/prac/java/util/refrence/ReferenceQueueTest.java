package com.prac.java.util.refrence;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Garbage collector appends the objects reference in ReferenceQueue. 
 * ReferenceQueue has the methods poll , remove . 
 * poll method fetches the reference object to check its availability. 
 * remove method removes the reference object from ReferenceQueue and and it waits until one object reference becomes available in ReferenceQueue.
 * @author sudhendu.kumar
 *
 */
public class ReferenceQueueTest {

	public static void main(String... args){
		ReferenceQueue rq= new ReferenceQueue(); 
		String s=new String("hello");
		Reference r= new PhantomReference(s,rq); 
		System.out.println(rq.poll());
		s=null;
		System.gc();	
		System.out.println(rq.poll());
		System.out.println(s);
	}
}
