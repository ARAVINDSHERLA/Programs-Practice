package com.concurrent.ExecutorFrameworkPractice;

/*Using Comparator in PriorityQueue:
Comparator is used with PriorityQueue. PriorityQueue provides a constructor that 
takes the initial size and Comparator object. It sorts then according to logic
 implemented in Comparator.
 */
import java.util.Comparator;
import java.util.PriorityQueue;
 
public class PriorityQueueComparatorDemo {
	public static void main(String... args ){
		PriorityQueueComparator pqc=new PriorityQueueComparator();
		PriorityQueue<String> pq=new PriorityQueue<String>(5,pqc);
		pq.add("ABC");
		pq.add("BD");
		pq.add("ABCD");
	
		for(String s:pq){ 
			System.out.println(s);
		}
	}
}
class PriorityQueueComparator implements Comparator{
	
	public int compare(Object p1, Object p2) {
		String s1=(String)p1;
		String s2=(String)p2;
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
	
	
	
}