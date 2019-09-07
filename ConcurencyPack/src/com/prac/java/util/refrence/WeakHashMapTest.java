package com.prac.java.util.refrence;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * The key of WeakHashMap has weak reference. 
 * If the key has been garbage collected, then the entry in WeakHashMap object will automatically be deleted.
 * It does not happen in normal HashMap. The entry will not be deleted if the key is garbage collected. 
 * @author sudhendu.kumar
 *
 */
public class WeakHashMapTest {

	public static void main(String[] args) {
		Map hashMap= new HashMap();
		
        Map weakHashMap = new WeakHashMap();
        
        String keyHashMap = new String("keyHashMap");
        String keyWeakHashMap = new String("keyWeakHashMap");
        
        hashMap.put(keyHashMap, "Ankita");
        weakHashMap.put(keyWeakHashMap, "Atul");
        System.gc();
        System.out.println("Before: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));
        
        keyHashMap = null;
        keyWeakHashMap = null;
        
        System.gc();  
        
        System.out.println("After: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));
    }
}
