package com.concurrent.ExecutorFrameworkPractice;
/*
 1.	ConcurrentSkipListMap is available from jdk 1.6
2.	By default the elements are fetched in natural order i.e in the 
order the elements are added. To get user defined order we can use Comparator. 
3.	Null value and null keys are not allowed. 
4.	ConcurrentSkipListMap is cloneable and Serializable. 
5.	ConcurrentSkipListMap extends NavigableMap, so it has the methods like 
ceilingEntry, ceilingKey,
 firstEntry, floorEntry etc which will return Map.Entry or NavigableMap.
 */

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListMap;
 
public class ConcurrentListMapDemo {
	
	public static void main(String... args){
 
		ConcurrentSkipListMap<String,String> ob= new ConcurrentSkipListMap<String,String>();
		ob.put("3","A");
		ob.put("2","B");
		ob.put("1","C");
		ob.put("5","D");
		ob.put("4","E");
       //returns a key-value mapping of the least value but greater than the given key.
		System.out.println("ceinling entry of 3:"+ob.ceilingEntry("3"));
		
		// returns the NavigableSet in reverse order
		 NavigableSet ns=ob.descendingKeySet();
		 
		System.out.println("Values in reverse order......");
		 Iterator itr=ns.iterator();
		 while(itr.hasNext()){
			 String s = (String)itr.next();
			 System.out.println(s);
		 }
        
		 // returns the  key value pair of least key in the map
		 System.out.println("Value with least key: "+ob.firstEntry());
		 
		 // returns the  key value pair of greatest key in the map
		 System.out.println("Value with greatest key: "+ob.lastEntry());
		 
		 //returns the lowest entry and also removes from the map
		 System.out.println("value removed from the map:"+ob.pollFirstEntry());
		 
		 //returns the greatest entry and also removes from the map
		 System.out.println("value removed from the map:"+ob.pollLastEntry());
	}
}