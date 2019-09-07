package com.prac.java.util.concurency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapMain {

	public static void main(String[] args) {
		ConcurrentHashMapMain concurrentHashMapMain=new ConcurrentHashMapMain();
		//concurrentHashMapMain.concurrentException();
		concurrentHashMapMain.concurrentMap();
	}
	
	public void concurrentMap() {
		ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("A","Apple");
        concurrentHashMap.put("B","Blackberry");
        concurrentHashMap.put("C","Clackberry");
        for (Map.Entry e : concurrentHashMap.entrySet()) {
        	concurrentHashMap.remove("B");
        	concurrentHashMap.put("D","DO");
        	System.out.println(e.getKey() + " = " + e.getValue());
            
        }
	}
	
	public void concurrentException() {
		
		Map<Integer,Integer> map=new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		
		for(Map.Entry<Integer,Integer> e:map.entrySet()) {
			System.out.println(e.getKey()+":"+e.getKey());
			//map.remove(2);
			map.put(4, 4);
			
		}
	}
	
}
