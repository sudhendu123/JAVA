package com.sample.java.collection;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String args[]){  
		   TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
		      map.put(100,"Amit");    
		      map.put(102,"Ravi");    
		      map.put(101,"Vijay");    
		      map.put(103,"Rahul");    
		        
		      for(Map.Entry<Integer,String> m:map.entrySet()){    
		       System.out.println(m.getKey()+" "+m.getValue());    
		      }    
		 }  
}
