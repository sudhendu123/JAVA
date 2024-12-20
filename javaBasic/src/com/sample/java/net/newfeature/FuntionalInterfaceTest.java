package com.sample.java.net.newfeature;

@FunctionalInterface  
interface sayable{  
    void say(String msg);  
} 

public class FuntionalInterfaceTest implements sayable{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
    	FuntionalInterfaceTest fie = new FuntionalInterfaceTest();  
        fie.say("Hello there");  
    }  
}  