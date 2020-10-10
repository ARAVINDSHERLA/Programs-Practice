package com.concurrent.ExecutorFrameworkPractice;

/*
 1.	CopyOnWriteArrayList is thread safe. 
2.	The operations like add, set in CopyOnWriteArrayList are made by taking fresh copy. 
3.	While iterating CopyOnWriteArrayList, we can not add are remove or modify. 
4.	CopyOnWriteArrayList is used in collection framework and this is available from jdk 1.5.
 */
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
 
public class CopyOnWriteArrayListDemo {
	public static void main(String... args){
		CopyOnWriteArrayList<String> ob= new CopyOnWriteArrayList<String>();
		//ArrayList ob=new ArrayList();
		ob.add("A");
		ob.add("B");
		ob.add("C");
		ob.add("D");
		ob.add("E");
		
		//ob.addIfAbsent("A");
		
		ob.remove("B");
		Iterator<String> itr= ob.listIterator();
		while(itr.hasNext()){
			String fail=itr.next();
			ob.remove(fail);
			System.out.println(fail);
			System.out.println(ob);
			
		}
	}
}