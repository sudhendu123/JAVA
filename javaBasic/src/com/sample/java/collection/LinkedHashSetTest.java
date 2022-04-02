package com.sample.java.collection;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	
	public static void main(String[] args) {  
		LinkedHashSet<Integer> lh=new LinkedHashSet<Integer>();
		lh.add(1);
		lh.add(3);
		lh.add(4);
		lh.add(2);
		lh.add(6);
		
		System.out.println("lh:"+lh);
	    LinkedHashSet<Book> hs=new LinkedHashSet<Book>();  
	    //Creating Books  
	    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
	    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
	    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);  
	    //Adding Books to hash table  
	    hs.add(b1);  
	    hs.add(b2);  
	    hs.add(b3);  
	    //Traversing hash table  
	    for(Book b:hs){  
	    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	    }  
	}  

}
