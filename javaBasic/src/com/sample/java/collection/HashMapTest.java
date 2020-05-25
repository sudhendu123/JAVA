package com.sample.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HashMapTest {

	public static void main(String[] args) {
		/* This is how to declare HashMap */
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		/* Adding elements to HashMap */
		hmap.put(1, "Chaitanya");
		hmap.put(2, "Ajeet");
		hmap.put(17, "Anuj");
		hmap.put(18, "Rahul");
		hmap.put(19, "Singh");
		
		
		//1 and 17 ,2 and 18 creates hash collision resolved by separate chaining 
		
		System.out.println(hmap.entrySet());	
		Set<String> mapValues = hmap.values().stream()
			    .sorted()
			    .collect(Collectors.toSet());
		System.out.println("mapValues :"+mapValues);
		List<Integer> mapKeys = hmap.keySet().stream()
			    .sorted()
			    .collect(Collectors.toList());
		System.out.println("mapKeys :"+mapKeys);
		
		/* Display content using Iterator */
		Set<?> set = hmap.entrySet();
		Iterator<?> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}

		for(Entry<Integer, String> ent:hmap.entrySet()) {
			System.out.println("entry set-->"+ent.getValue()+":"+ent.getKey());
		}
		/* Get values based on key */
		String var = hmap.get(2);
		System.out.println("Value at index 2 is: " + var);

		/* Remove values based on key */
		hmap.remove(3);
		System.out.println("Map key and values after removal:");
		Set set2 = hmap.entrySet();
		Iterator iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry mentry2 = (Map.Entry) iterator2.next();
			System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
			System.out.println(mentry2.getValue());
		}

		// FOR LOOP
		System.out.println("For Loop:");
		for (Map.Entry me : hmap.entrySet()) {
			System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
		}

		// Checking Key Existence
	    boolean flag = hmap.containsKey(49);
	    System.out.println("Key 22 exists in HashMap? : " + flag);
	    
	 // Checking Value Existence
	    boolean flag1 = hmap.containsValue("Rahul");
	    System.out.println("String Singh exists in HashMap? : " + flag1);
	    
	    empl q=new empl(1,"name1",21,"210000");
	    empl q1=new empl(2,"name2",21,"220000");
	    empl q2=new empl(3,"name3",21,"230000");
	    
	    Map<Integer,empl> objMap=new HashMap<>();
	    objMap.put(1, q);
	    objMap.put(2, q1);
	    objMap.put(3, q2);
	    int age = objMap.entrySet().stream().map(m->m.getValue().getAge()).collect(Collectors.toList()).get(0);
	    System.out.println("age :"+age);
	    List<empl> emplList=new ArrayList<>();
	    emplList.add(q);
	    emplList.add(q1);
	    List<empl> emplList1=new ArrayList<>();
	    emplList1.add(q2);
	    Map<String, List<String>> complexMap=new HashMap<>();
	    List<String> stringList=new ArrayList<>();
	    stringList.add("q");
	    stringList.add("q1");
	    List<String> stringList1=new ArrayList<>();
	    stringList1.add("q2");
	    stringList1.add("q3");
	    complexMap.put("91886", stringList);
	    complexMap.put("91887", stringList1);
	    
	    //sorting map
	    Map<Integer, Integer> hmap1 = new TreeMap<>();
	    Map<Integer, Integer> hmap2 = new TreeMap<>();
	    hmap1.put(1,1);
	    hmap1.put(3,2);
	    //hmap1.put(4,5);
	    //hmap1.put(2,3);
	    System.out.println("sorted Map "+hmap1);
	    
	    String sb12=hmap1.keySet().stream().map(Object::toString).collect(Collectors.joining(","));
	    String sb11=hmap1.values().stream().map(Object::toString).collect(Collectors.joining(","));
	    //System.out.println("sb1 :"+new BigInteger(sb12));
	    System.out.println("sb2 :"+sb11);
	    
	    //complex
	    List<String> listStr=new ArrayList<>();
	    listStr.add("a");
	    listStr.add("b");
	    List<String> listStr1=new ArrayList<>();
	    listStr1.add("c");
	    listStr1.add("d");
	    List<String> listStr2=new ArrayList<>();
	    listStr2.add("e");
	    listStr2.add("f");
	    Map<String, List<String>> complex = new HashMap<String, List<String>>();
	    complex.put("1", listStr);
	    complex.put("2", listStr1);
	    complex.put("3", listStr2);
	    Collection<List<String>> valuess = complex.values();
	    System.out.println("valuess ="+valuess.stream().filter(a->a.contains("d")).collect(Collectors.toList()));
	    boolean got = complex.get("1").contains("c");
	    System.out.println("got ="+got);
	    
	    Iterator<Entry<String, List<String>>> it = complex.entrySet().iterator();
	    while(it.hasNext()) {
	    	Entry<String, List<String>> ele = it.next();
	    	if(ele.getKey().contains("4")) {
	    		it.remove();
	    	}
	    }
	    System.out.println("complex :"+complex);
	    List<String> allType=new ArrayList<>();
	    allType.add("f");
	    allType.add("d");
	    List<String> removeType=new ArrayList<>();
	    for(Map.Entry<String, List<String>> e:complex.entrySet()) {
	    	List<String> all = e.getValue();
	    	System.out.println("all ="+all);
	    	for(String re:all) {
	    		if(allType.contains(re)) {
	    			removeType.add(e.getKey());
	    		}
	    	}
	    	
	    }
	    
	    empl e=null;
	    e.setAge(1);
	    
	}	
	
	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
	    return map.entrySet()
	              .stream()
	              .filter(entry -> Objects.equals(entry.getValue(), value))
	              .map(Map.Entry::getKey)
	              .collect(Collectors.toSet());
	}
}


class empl{
	
	int id;
	String name;
	int age;
	String sal;
	
	public empl() {}
	public empl(int id, String name, int age, String sal) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "empl [id=" + id + ", name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sal == null) ? 0 : sal.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		empl other = (empl) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sal == null) {
			if (other.sal != null)
				return false;
		} else if (!sal.equals(other.sal))
			return false;
		return true;
	}
	
	
	
}
