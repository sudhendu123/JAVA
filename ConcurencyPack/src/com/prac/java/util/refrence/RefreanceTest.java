package com.prac.java.util.refrence;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class RefreanceTest {
	
	public static void main(String[] args) {
		
		// Strong Reference 
        Gfg g2 = new Gfg();    
        g2.x(); 
          
        // Creating Weak Reference to Gfg-type object to which 'g'  
        // is also pointing. 
        WeakReference<Gfg> weakref = new WeakReference<Gfg>(g2); 
          
        //Now, Gfg-type object to which 'g' was pointing earlier 
        //is available for garbage collection. 
        //But, it will be garbage collected only when JVM needs memory. 
        g2 = null;  
          
        // You can retrieve back the object which 
        // has been weakly referenced. 
        // It succesfully calls the method. 
        g2 = weakref.get();  
          
        g2.x();  
		// Strong Reference 
        Gfg g1 = new Gfg();    
        g1.x(); 
          
        // Creating Soft Reference to Gfg-type object to which 'g'  
        // is also pointing. 
        SoftReference<Gfg> softref = new SoftReference<Gfg>(g1); 
          
        // Now, Gfg-type object to which 'g' was pointing 
        // earlier is available for garbage collection. 
        g1 = null;  
          
        // You can retrieve back the object which 
        // has been weakly referenced. 
        // It succesfully calls the method. 
        g1 = softref.get();  
          
        g1.x(); 
		
		
		//Strong Reference 
        Gfg g = new Gfg();    
        g.x(); 
          
        //Creating reference queue 
        ReferenceQueue<Gfg> refQueue = new ReferenceQueue<Gfg>(); 
  
        //Creating Phantom Reference to Gfg-type object to which 'g'  
        //is also pointing. 
        PhantomReference<Gfg> phantomRef = null; 
          
        phantomRef = new PhantomReference<Gfg>(g,refQueue); 
          
        //Now, Gfg-type object to which 'g' was pointing 
        //earlier is available for garbage collection. 
        //But, this object is kept in 'refQueue' before  
        //removing it from the memory. 
        g = null;  
          
        //It always returns null.  
        g = phantomRef.get();  
          
        //It shows NullPointerException. 
        g.x(); 
	}

}

class Gfg 
{ 
    //code 
    public void x() 
    { 
        System.out.println("GeeksforGeeks"); 
    } 
} 
