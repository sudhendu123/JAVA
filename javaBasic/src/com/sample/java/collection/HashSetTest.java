package com.sample.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set1=new HashSet<>();
		set1.add("4");
		set1.add("2");
		
		Set<String> set2=new HashSet<>();
		set2.add("1");
		set2.add("2");
		set2.add("3");
		set1.removeAll(set2);
		System.out.println("elements after remove: "+set1);
		
		Set<empl> empSet=new HashSet<>();
		empSet.add(new empl(1,"abc",24,"10000"));
		empSet.add(new empl(2,"abc2",22,"20000"));
		empSet.add(new empl(3,"abc3",23,"30000"));
		empSet.add(new empl(4,"abc2",24,"4000"));
		empSet.add(new empl(5,"abc2",24,"4000"));
		empSet.add(new empl(6,"abc6",24,"4000"));
		empSet.add(new empl(1,"abc",24,"10000"));
		
		Set<Integer> idSet = empSet.stream().map(empl::getId).collect(Collectors.toSet());
	}
}
