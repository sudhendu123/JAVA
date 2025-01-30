package com.prac.ds.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MathTest {
	static Boolean var;
	
	public static void main(String[] args) {
		List<Integer> l=new ArrayList<>();
		Set<Integer> s=new HashSet<>();
		s.add(null);
		
		PriorityQueue<String> p=new PriorityQueue<String>();
		p.add("paper");
		p.add("pen");
		p.add("pencil");
		System.out.println(p.poll());
		
		
		
		
		
		String str = "1100";
        System.out.println("lex:"+LexicographicalMaxString(str));
        
   
		
	}
	
	String getOptimalString(String s) {
		String ans;
	    int n=s.length();
	    String[] stt = s.split("");
	    
		char first = s.charAt(0);
		char last = s.charAt(s.length() - 1);
		
	    Arrays.sort(first,last);
	    reverse(s.begin(),s.end());
	    if(n%2) ans.push_back(s[n/2]);
	    for(int i=(n+1)/2,j=(n-2)/2;j>=0 && i<n;j--,i++){
	        ans.push_back(s[i]);
	        ans.push_back(s[j]);
	    }
	    return ans;
	}
	

}
class p{
	void m1() {
		System.out.println("m1");
	}
}
class d extends p{
	
	void m1() {
		System.out.println("m12");
	}
}


