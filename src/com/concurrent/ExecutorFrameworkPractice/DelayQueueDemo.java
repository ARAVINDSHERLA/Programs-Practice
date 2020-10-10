package com.concurrent.ExecutorFrameworkPractice;

/*
 1.	DelayQueue is an unbounded queue. It extends Delayed interface.
2.	Element from DelayQueue can only be taken when its delay has expired.
3.	At the head of the queue , element with furthest expired delay time is found.
4.	An element is expired when its getDelay() method returns a value less than or 
equal to zero.
5.	Null is not permitted in DelayQueue. 
6.	In DelayQueue, only those object can be inserted which implements Delayed interface. 

Find the example of DelayedQueue. I have created a class DelayedTest 
extending Delayed interface.
 This will implement compareTo and getDelay() method
 */
import java.util.Iterator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
 
public class DelayQueueDemo  {
	public static void main(String... args){
		DelayQueue<DeleyedTest>  dq=new DelayQueue<DeleyedTest>();
		DeleyedTest ob1=new DeleyedTest(10);
		DeleyedTest ob2=new DeleyedTest(5);
		DeleyedTest ob3=new DeleyedTest(15);
		
		dq.offer(ob1);
		dq.offer(ob2);
		dq.offer(ob3);
		
		Iterator<DeleyedTest> itr=dq.iterator();
		while(itr.hasNext()){
			DeleyedTest dt=(DeleyedTest)itr.next();
			System.out.println(dt.deleyTime);
		}
	}
}
class DeleyedTest implements Delayed{
    public long deleyTime=0;
    DeleyedTest(long deleyTime){
    	this.deleyTime=deleyTime;
    }
    
	@Override
	public int compareTo(Delayed ob) {
		if(this.deleyTime<((DeleyedTest)ob).deleyTime){
			return -1;
		}else if(this.deleyTime>((DeleyedTest)ob).deleyTime){
			return 1;
		}
		return 0;
	}
	@Override
	public long getDelay(TimeUnit unit) {
		unit.convert(deleyTime-System.currentTimeMillis(),TimeUnit.NANOSECONDS); 
		return 0;
	}
	
}