package com.sample.java.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {

	public static void main(String[] args) {  
        int j =1;  
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();  
        for (int i = 1; i <=5; i++) {  
            //  Adding items to the tail of this queue  
            queue.add(i);}  
            //inserts the element at the tail of this queue  
            queue.offer(6);  
            System.out.println("Queue : "+queue);  
            //Returns true if this queue contains the specified element  
            if(queue.contains(4)){  
                System.out.println("This queue conatins 4");  
            }  
            else{  
                System.out.println("4 is absent");  
            }  
        //returns true if the queue is empty  
        if(queue.isEmpty()){  
            System.out.println("Add some elements because the queue is empty.");  
        }  
        else{  
            System.out.println("Queue is not empty");  
        }
        
        ConcurrentLinkedQueue<Integer> queue1 = new ConcurrentLinkedQueue<Integer>();  
        List<Integer> list = new ArrayList<Integer>();  
        queue1.add(11);  
        queue1.add(100);  
        queue1.add(122);  
        queue1.add(102);  
        queue1.add(112);  
        list.add(11);  
        list.add(100);  
        System.out.println("Elements in queue1 : "+queue1);  
        //remove() method will remove the specified element from the queue1  
        queue1.remove(122);  
        queue1.remove(102);  
        System.out.println("Remaining elements in queue1 : "+queue1);  
        //Removes all the elements of this in queue1 which are present in the list  
        queue1.removeAll(list);  
        System.out.println("Elemts of the list will get removed : "+queue1);  
        //Retain only those elements in this queue1 that are present in the list  
        queue1.retainAll(list);  
        System.out.println("queue1 will retain the elements of the list: "+queue1);  
    }  
}
