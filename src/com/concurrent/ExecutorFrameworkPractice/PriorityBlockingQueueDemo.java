package com.concurrent.ExecutorFrameworkPractice;

/*
 1.	PriorityBlockingQueue has the property of both PriorityQueue and BlockingQueue.
2.	It uses the ordering rule of PriorityQueue.
3.	It implements the methods like add, drainTo, offer, poll, peek, remove,put etc.

Find the example which will use some of the methods of PriorityBlockingQueue.
 */
/*
 output:
 Data after addition.
A B C D 
List Data after using drainTo
A B 
PriorityBlockingQueue Data after using drainTo
C D 
Data after using remove.
C 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
 
public class PriorityBlockingQueueDemo {
	
	  public static void main(String... args){
		  PriorityBlockingQueue pbq=new PriorityBlockingQueue();
		  pbq.add("A");
		  pbq.add("B");
		  pbq.add("C");
		  pbq.add("D");
		  
		  show(pbq.iterator(),"Data after addition.");
		  		  
		   List list=new ArrayList();
		  pbq.drainTo(list,2);
		  
		  show(list.iterator(),"List Data after using drainTo");
		  show(pbq.iterator(),"PriorityBlockingQueue Data after using drainTo");
		  
		  pbq.remove("D");
		  show(pbq.iterator(),"Data after using remove.");
		 
		  
		  
	  }
	  
	  public static void show(Iterator itr,String msg){
		  System.out.println("\n"+msg);
		  while(itr.hasNext()){
			  String s=(String)itr.next();
			  System.out.print(s+" ");
		  }
	  }
}