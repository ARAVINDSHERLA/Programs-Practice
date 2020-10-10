package com.concurrent.ExecutorFrameworkPractice;

/*
 1.	SynchronousQueue implements BlockingQueue interface.
2.	The put method waits fro take and take method waits for put. 
3.	No element can be added without the call of take and no element can 
be removed without the call of put. 
4.	It has no size, at synchronous point element is put and take. 
5.	SynchronousQueue allows optional fairness ordering for the threads that 
are waiting to take. 
6.	It does not allow null values.
 */
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
	
	private SynchronousQueue sq = new SynchronousQueue(true);  
	
	 class PutThread implements Runnable {
	     public void run() {
	        	 try {
					sq.put("A");
					//sq.put("B");
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
	         }
	    }
	   class TakeThread implements Runnable {
	     public void run() {
	          	 try {
					System.out.println(sq.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	         }
	   }
	   public static void main(String... args) {
	     
	     new Thread((new SynchronousQueueDemo()).new PutThread()).start();
	     new Thread((new SynchronousQueueDemo()).new TakeThread()).start();
	   }
}
   