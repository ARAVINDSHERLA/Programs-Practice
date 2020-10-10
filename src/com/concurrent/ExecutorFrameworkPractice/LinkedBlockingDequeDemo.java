package com.concurrent.ExecutorFrameworkPractice;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
 

/*
LinkedBlockingDeque comes under the package java.util.concurrent. 
LinkedBlockingDeque implements BlockingDeque interface. LinkedBlockingDeque works on
 the basis of linked nodes. We can define the capacity of LinkedBlockingDeque. 
 LinkedBlockingDeque nodes are created dynamically. 
 This class comes from jdk1.6 and is related to Java Collection Framework. 
 Find the example of LinkedBlockingDeque. drainTo method 
deduct the data from LinkedBlockingDeque from bottom and add it to given collection.


*/
/*
 
Data after adding.
B A C D 
After using addFirst and addLast
E B A C D F 
List Data after using drainTo
E B 
LinkedBlockingDeque Data after using drainTo
A C D F 
 */
public class LinkedBlockingDequeDemo {
	  public static void main(String... args){
		  LinkedBlockingDeque lbd=new LinkedBlockingDeque();
		  lbd.add("B");
		  lbd.add("A");
		  lbd.add("C");
		  lbd.add("D");
		  
		  show(lbd.iterator(),"Data after adding.");
		  lbd.addFirst("E");
		  lbd.addLast("F");
		  show(lbd.iterator(),"After using addFirst and addLast");		  
		  List list=new ArrayList();
		  lbd.drainTo(list,2);
		  
		  show(list.iterator(),"List Data after using drainTo");
		  show(lbd.iterator(),"LinkedBlockingDeque Data after using drainTo");
		  
		  
	  }
	  
	  public static void show(Iterator itr,String msg){
		  System.out.println("\n"+msg);
		  while(itr.hasNext()){
			  String s=(String)itr.next();
			  System.out.print(s+" ");
		  }
	  }
	  
}