package com.sample.java.prgm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountCharInSent {
	public static void main(String[] args) {
		CountCharInSent.findIt("India is my country");  
	}

	public static void findIt(String str) {  
        Map<Character, Integer> baseMap = new HashMap<>();  
        char[] charArray = str.toCharArray();  
        for (Character ch : charArray) {  
            if (baseMap.containsKey(ch)) {  
                baseMap.put(ch, baseMap.get(ch) + 1);  
            } else {  
                baseMap.put(ch, 1);  
            }  
        }  
        System.out.println(baseMap);
        for(Map.Entry<Character, Integer> m:baseMap.entrySet()) {
        	System.out.println(m.getKey()+" : "+m.getValue());
        }
        	
      
    }  
}
