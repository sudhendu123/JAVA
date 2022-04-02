package com.sample.java.collection;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
	public static void main(String[] args) {  
	    Queue<Books> queue=new PriorityQueue<Books>();  
	    //Creating Books  
	    Books b1=new Books(121,"Let us C","Yashwant Kanetkar","BPB",8);  
	    Books b2=new Books(233,"Operating System","Galvin","Wiley",6);  
	    Books b3=new Books(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
	    //Adding Books to the queue  
	    queue.add(b1);  
	    queue.add(b2);  
	    queue.add(b3);  
	    System.out.println("Traversing the queue elements:");  
	    //Traversing queue elements  
	    for(Books b:queue){  
	    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	    }  
	    queue.remove();  
	    System.out.println("After removing one book record:");  
	    for(Books b:queue){  
	        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	        }  
	    
	    PriorityQueue<String> queuee=new PriorityQueue<String>();  
	    queuee.add("Amit");  
	    queuee.add("Vijay");  
	    queuee.add("Karan");  
	    queuee.add("Jai");  
	    queuee.add("Rahul");  
	    System.out.println("head:"+queuee.element());  
	    System.out.println("head:"+queuee.peek());  
	    System.out.println("iterating the queue elements:");  
	    Iterator itr=queuee.iterator();  
	    while(itr.hasNext()){  
	    System.out.println(itr.next());  
	    }  
	    queue.remove();  
	    queue.poll();  
	    System.out.println("after removing two elements:");  
	    Iterator<String> itr2=queuee.iterator();  
	    while(itr2.hasNext()){  
	    System.out.println(itr2.next());  
	    }  
	}  

}

class Books implements Comparable<Books>{  
int id;  
String name,author,publisher;  
int quantity;  
public Books(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  
    this.name = name;  
    this.author = author;  
    this.publisher = publisher;  
    this.quantity = quantity;  
}  
public int compareTo(Books b) {  
    if(id>b.id){  
        return 1;  
    }else if(id<b.id){  
        return -1;  
    }else{  
    return 0;  
    }  
}  
}  