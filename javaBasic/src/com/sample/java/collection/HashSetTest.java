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
		
		Set<Empl> dbEmpSet=new HashSet<>();
		dbEmpSet.add(new Empl(1,"abc",24,"10000"));
		dbEmpSet.add(new Empl(2,"abc2",22,"20000"));
		dbEmpSet.add(new Empl(3,"abc3",23,"30000"));
		dbEmpSet.add(new Empl(4,"abc2",24,"4000"));
		dbEmpSet.add(new Empl(5,"abc2",24,"4000"));
		dbEmpSet.add(new Empl(6,"abc6",24,"4000"));
		dbEmpSet.add(new Empl(1,"abc",24,"10000"));
		
		Set<Integer> idSet = dbEmpSet.stream().map(Empl::getId).collect(Collectors.toSet());
		System.out.println("idSet :"+idSet);
		
		Set<Empl> modempSet=new HashSet<>();
		modempSet.add(new Empl(1,"abc",24,"10001"));
		modempSet.add(new Empl(2,"abc2",22,"20001"));
		
		Set<Empl> finalEmp=new HashSet<>();
		
		modempSet.forEach(p ->
		dbEmpSet.stream()
                      .filter(p1 -> p.getId()==p1.getId())
                      .forEach(finalEmp::add));
		
		System.out.println("finalEmp :"+finalEmp);
		
		modempSet.forEach(p ->
		dbEmpSet.stream()
                      .filter(p1 -> p.getId()==p1.getId()
                      && p.getAge()==p1.getAge())
                      .forEach(finalEmp::add));
		
		System.out.println("finalEmp :"+finalEmp);
		
	}
}
