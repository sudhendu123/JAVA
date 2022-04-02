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
		
		
		HashMap<String, String> hmapString = new HashMap<String, String>();
		hmapString.put("a","a");
		//hmapString.put("b",null);
		hmapString.put("d","d");
		//hmapString.put("c",null);
		
		List<String> removed = new ArrayList<String>();
		removed.add("a");
		List<String> nullEl = hmapString.entrySet().stream().filter(q->q.getValue()!=null).map(q->q.getKey()).collect(Collectors.toList());
		System.out.println("nullEl :"+nullEl);
		nullEl.removeAll(removed);
		System.out.println("nullEl :"+nullEl);
		
		/* This is how to declare HashMap */
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		List<String> emptyList = hmap.values().stream().filter(a->a.equals("0")).map(q->q).collect(Collectors.toList());
		System.out.println("emptyList :"+emptyList);
		
		/* Adding elements to HashMap */
		hmap.put(1, "Chaitanya");
		hmap.put(2, "Ajeet");
		hmap.put(3, "Ak");
		hmap.put(4, "sk");
		hmap.put(17, "Anuj");
		hmap.put(18, "Rahul");
		hmap.put(19, "Singh");
		
		System.out.println("hmap :"+hmap);
		
		//first entry
		Entry<Integer, String> firstEntry = hmap.entrySet().stream().findFirst().get();
		System.out.println(" firstEntry:"+firstEntry);
		
		
		//1 and 17 ,2 and 18 creates hash collision resolved by separate chaining 
		
		System.out.println("entry set:"+hmap.entrySet());	
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

		

		// Checking Key Existence
	    boolean flag = hmap.containsKey(49);
	    System.out.println("Key 22 exists in HashMap? : " + flag);
	    
	 // Checking Value Existence
	    boolean flag1 = hmap.containsValue("Rahul");
	    System.out.println("String Singh exists in HashMap? : " + flag1);
	    
	    System.out.println("################### remove #################");
	    /* Remove values based on key */
		hmap.remove(4);
		System.out.println("Map key and values after removal sk:");
		// FOR LOOP
		System.out.println("For Loop:");
		for (Map.Entry<Integer,String> me : hmap.entrySet()) {
			System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
		}
	    //remove list of value by list of keys
	  	List<Integer> profileMdnLists=new ArrayList<>();
	  	profileMdnLists.add(3);
	  	hmap.keySet().removeAll(profileMdnLists);
	  	System.out.println("After removing AK hmap :"+hmap);
	  	//remove not part of key list
	  	hmap.keySet().removeIf(e->!profileMdnLists.contains(e));
	    // remove by value
	    hmap.values().removeIf(value -> value.contains("Chaitanya"));
	    System.out.println("removed Chaitanya:"+hmap);
	    // remove by key
	    hmap.keySet().removeIf(key -> key == 2);
	    System.out.println("removed Ajeet by key 2"+hmap);
	    // remove by entry / combination of key + value
	    hmap.entrySet().removeIf(entry -> entry.getKey() != 17);
	    System.out.println("Removed rest except Anuj:"+hmap);
	    
	    System.out.println("################### remove #################");
	    
	    //filtering map
	    Empl q=new Empl(1,"name1",21,"210000");
	    Empl q1=new Empl(2,"name2",21,"220000");
	    Empl q2=new Empl(3,"name3",21,"230000");
	    
	    Map<Integer,Empl> objMap=new HashMap<>();
	    objMap.put(1, q);
	    objMap.put(2, q1);
	    objMap.put(3, q2);
	    int age = objMap.entrySet().stream().map(m->m.getValue().getAge()).collect(Collectors.toList()).get(0);
	    System.out.println("First Age :"+age);
	    List<Integer> ageList = objMap.entrySet().stream().map(m->m.getValue().getAge()).collect(Collectors.toList());
	    System.out.println("ageList  :"+ageList);
	    List<String> nameList = objMap.values().stream().map(Empl::getName).collect(Collectors.toList());
	    System.out.println("nameList  :"+nameList);
	    List<Integer> idCondition = objMap.entrySet().stream().filter(m->m.getValue().getId()!=2).map(m ->m.getKey()).collect(Collectors.toList());
	    System.out.println("idCondition  :"+idCondition);
	    
	    List<Empl> emplList=new ArrayList<>();
	    emplList.add(q);
	    emplList.add(q1);
	    List<Empl> emplList1=new ArrayList<>();
	    emplList1.add(q2);
	    Map<String, List<Empl>> complexMap1=new HashMap<>();
	    complexMap1.put("1", emplList);
	    complexMap1.put("2", emplList1);
	    System.out.println("complexMap1 ="+complexMap1);
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
	    
	    Empl e=null;
	    //e.setAge(1);
	    
	    Map<String, Integer> groupByMap =new HashMap<String, Integer>();
	    groupByMap.put("1", 1);
	    groupByMap.put("21", 2);
	    groupByMap.put("31", 1);
	    groupByMap.put("2", 1);
	    groupByMap.put("3", 2);
	    
	    Map<Integer, List<String>> result =  groupByMap.entrySet().stream().collect(Collectors.groupingBy(
	            Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
	    System.out.println("Group By result "+result);
	    
	    Map<Integer, List<String>> result1 = new HashMap<Integer, List<String>>();
	    for(Entry<String,Integer> entry : groupByMap.entrySet()){
	            List<String> list = new ArrayList<String>();
	            if(result1.containsKey(entry.getValue()))
	                list = result1.get(entry.getValue());
	            list.add(entry.getKey());
	            result1.put(entry.getValue(), list);
	    }
	    System.out.println("Group By result1 "+result1);
	    
	}	
	
	//get key from value
	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
	    return map.entrySet()
	              .stream()
	              .filter(entry -> Objects.equals(entry.getValue(), value))
	              .map(Map.Entry::getKey)
	              .collect(Collectors.toSet());
	}
	
	//get key from value
    public static <K, V> K getKey0(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    
	//get key from value
	public static <K, V> K getKey(Map<K, V> map, V value)
	{
	    return map.entrySet()
	                .stream()
	                .filter(entry -> value.equals(entry.getValue()))
	                .map(Map.Entry::getKey)
	                .findFirst().get();
	}
	
	//get key from value
	public static <K, V> K getKe1y(Map<K, V> map, V value)
    {
        for (K key: map.keySet())
        {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
	
	//get key from value
	public static <K, V> K getKey2(Map<K, V> map, V value)
	{
	    return map.keySet()
	                .stream()
	                .filter(key -> value.equals(map.get(key)))
	                .findFirst().get();
	}
}


class Empl{
	
	int id;
	String name;
	int age;
	String sal;
	
	public Empl() {}
	public Empl(int id, String name, int age, String sal) {
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
		Empl other = (Empl) obj;
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

class Empl1 extends Empl{
	
	int dept;

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}
		
	
	
}
