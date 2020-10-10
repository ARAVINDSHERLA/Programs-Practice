package com.concurrent.ExecutorFrameworkPractice;
/*
 1.	Priority queue is unbounded queue.
2.	It is ordered collection. It iterates the element in the same order as in the order it is added.
3.	Comparator provides the user defined order to PriorityQueue.
4.	The size of PriorityQueue automatically grows when element is added. 
Using PriorityQueue methods
In our example below, see the use of PriorityQueue methods like add, poll and 
remove etc. add methods add the element in PriorityQueue. poll method fetches 
the element from head and removes it. remove method removes the specified element.*/

import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String... args ){
		PriorityQueue<String> pq=new PriorityQueue<String>();
		pq.add("A");
		pq.add("B");
		pq.add("C");
		pq.add("D");
		System.out.println("After Using add method.");
		for(String s:pq){ 
			System.out.println(s);
		}
		
		System.out.println("After Using poll method.");
		pq.poll();
		for(String s:pq){ 
			System.out.println(s);
		}
		System.out.println("After Using remove method.");
		pq.remove("D");
		for(String s:pq){ 
			System.out.println(s);
		}
	}
}