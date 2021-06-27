package com.sample.java.basic;

import java.io.Console;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

public class SystemClassMethods {
	
	public static void main(String[] args) {
        String a[]= {"D","P","R","E","K","A"}; //source array  
        String b[]= {"E","D","U","V","O","I","D","L","E","A","R","N","I","N","G"};  //destination array  
        String src[],dest[];  
         
        int srcPos,destPos,length;
        src=a;
        srcPos=2;
        dest=b;
        destPos=3;
        length=4;
         
        System.out.print("Source array:"); 
         
        for(int i=0;i<src.length;i++) {System.out.print(a[i]);}  
        System.out.println(); 
         
        System.out.print("Destination array:");         
        for(int i=0;i<dest.length;i++) {System.out.print(b[i]);}  
        System.out.println();  
        System.out.println("Source Position:"+srcPos);  
        System.out.println("Destination Position:"+destPos);  
        System.out.println("Length:"+length);  
        System.arraycopy(src, srcPos, dest, destPos, length); //use of arraycopy() method 
         
        System.out.println("After Copying Destination Array: "); 
        for(int i=0;i<b.length;i++)  
        {
            System.out.print(b[i]);  
        }  
        System.out.println();
         
         
        System.out.println("---------Implementing NanoTime Method----------");
        System.out.println("Current time in nanoseconds = "+System.nanoTime());  
 
         
        System.out.println();
        System.out.println("---------Implementing getProperties() Method----------");
        System.out.println("Your System property for user");  
        Properties p = System.getProperties();  
        System.out.println(p.getProperty("user.name")); //property to get User's account name  
        System.out.println(p.getProperty("user.home")); //property to get User's home directory  
        System.out.println(p.getProperty("user.dir")); //property to get User's current working directory 
         
        System.out.println();
        System.out.println("---------Implementing console() Method----------");
        Console console = System.console();
 
        if(console != null){
            Calendar c = new GregorianCalendar();
            console.printf("Welcome %1$s%n", "Edureka"); 
            console.printf("Current time is: %1$tm %1$te,%1$tY%n", c); 
            console.flush();
        } else{
            //No console is attached when executed in Eclipse
            System.out.println("No Console attached");
        }
         
        System.out.println();
        System.out.println("---------Implementing getSecurityManager() Method----------");
        SecurityManager secManager = System.getSecurityManager();
        if(secManager == null){
            System.out.println("SecurityManager is not configured");
        }
        SecurityManager mySecManager = new SecurityManager();
         
        System.setSecurityManager(mySecManager);
        secManager = System.getSecurityManager();
        if(secManager != null){
            System.out.println("SecurityManager is now configured");
        }        
   }

}
