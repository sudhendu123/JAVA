package com.sample.java.prgm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

//import com.sample.java.array.ArrayList;

public class Test {
	
	final static int a=10;
	public static void main(String[] args) {
		LinkedList<Integer> profileMdnLists=new LinkedList<>();
	  	profileMdnLists.add(3);
	  	profileMdnLists.add(2);
		LinkedHashMap<String, LinkedList<Integer>> delContactStatus =new LinkedHashMap<String, LinkedList<Integer>>();
		delContactStatus.put("1", profileMdnLists);
		delContactStatus.put("2", profileMdnLists);
		
		LinkedList<Integer> firstEntry = delContactStatus.entrySet().stream().findFirst().get().getValue();
	  	System.out.println(" firstEntry :"+firstEntry);
		Collection<String> dbMdnList =new ArrayList<>();
		dbMdnList.add("1");
		dbMdnList.add("2");
		
		Collection<String> req =new ArrayList<>();
		req.add("1");
		req.add("3");
		
		Map<String,String> onlineMdns =new HashMap<String, String>();
		List<String> onlineMdnList = new LinkedList<>(onlineMdns.keySet());
		System.out.println(" dbMdnList2:"+onlineMdnList.isEmpty());
		
		Collection<Integer> reqInt =new ArrayList<>();
		reqInt.add(1);
		reqInt.add(3);
		
		Collection<Integer> subs =new ArrayList<>();
		subs.add(1);
		
		//req.removeAll(dbMdnList);
		boolean containEl = reqInt.stream().allMatch(subs::contains);
		
		Set<Integer> subscrsCorpIds =new HashSet<>();
		subscrsCorpIds.add(1);
		subscrsCorpIds.add(1);
		
		Set<Integer> subscrsCorpIds1 =new HashSet<>();
		subscrsCorpIds1.add(1);
		boolean containsubscrsCorpIds1 = subscrsCorpIds.stream().allMatch(subscrsCorpIds1::contains);
		boolean containsAll = subscrsCorpIds1.containsAll(subscrsCorpIds);
		
		System.out.println(" containEl:"+containEl +" req;"+req.isEmpty()+" contains:"+containsubscrsCorpIds1);
		System.out.println(" containsAll:"+containsAll);
		
		Map<Integer,Student> map=new HashMap();
		
		List<Student> list=new ArrayList();
		list.add(new Student(1,"1",1));
		list.add(new Student(2,"2",2));
		
		for(Student i:list) {
			if(i.getAge()!=map.get(i).getAge()) {
				System.out.println("yes");
			}
		}
		
		int a[]=new int[10];
		a[0]=1;
		
		int a1[]= {1,2};
		System.out.println("1: "+a[1]);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		for(int j:a1) {
			System.out.println(j); 
		}
		
		me(new int[] {2,3});
		
		int arr[][]= {{1,2,3},{3,4,5}};
		System.out.println("srr len:"+arr.length);
		for(int j=0;j<arr.length;j++) {
			System.out.println("j length :"+arr[j].length);
			for(int q=0;q<arr[j].length;q++) {
				System.out.println(" ar "+arr[j][q]);
			}
		}
		 
	}
	
	public static void me(int a[]) {
		for(int j:a) {
			System.out.println(j); 
		}
	}
	

}
abstract class anno{
	public abstract void ann();
}

class callTest implements Callable<String>{
	public String call() {
		return "in call";
		
	}
}


class Student {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
/**
	public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
	}
**/
	// reverse order
	/**
	  public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		else if (age < st.age)
			return 1;
		else
			return -1;
	}
	**/
	/**
	public int compareTo(Student st){
	     int last = this.name.compareTo(st.name);
	     return last == 0 ? this.name.compareTo(st.name) : last;
	  }
	  **/
	
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
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
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", age=" + age + "]";
	}
	
	
}