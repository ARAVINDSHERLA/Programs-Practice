package com.concurrent.ExecutorFrameworkPractice;


/*Semaphore class in java belongs to the package java.util.concurrent. 
Semaphore is available from jdk1.5. Semaphore is used in concurrency.
It has set of permits for a resource required by a thread.
A thread acquires a permit from semaphore through acquire method and permit is
released to semaphore through release method and thread is retuned back to thread pool.
In the constructor of Semaphore, we pass the two parameter one is number of permits 
and Boolean fairness policy. If fairness is set false, Semaphore will not 
give guarantee for ordering of allocation of permits to threads that 
needs to acquire recourse but if fairness is set to true then semaphore 
gives the permit in a order
in which threads needs the resource. Find the example of Semaphore.*/

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	   private final int MAX_COUNT=10;
	   private final Semaphore sem = new Semaphore(MAX_COUNT, true);
	   private boolean[] flag = new boolean[MAX_COUNT];
	   private Object[] res = new Object[MAX_COUNT];
 
	   public synchronized Object getResource() throws InterruptedException {
	     sem.acquire();
	     for (int i = 0; i < MAX_COUNT; ++i) {
		       if (!flag[i]) {
		    	   flag[i] = true;
		          return res[i];
		       }
		 }
	     return null;
	   }
 
	   public synchronized void putResource(Object ob) {
		   boolean isRes=false;
		   for (int i = 0; i < MAX_COUNT; ++i) {
		       if (ob == res[i]) {
		          if (flag[i]) {
		        	  flag[i] = false;
		        	  isRes= true;
		          } else
		        	  isRes= false;
		       }
		     }
		     if(isRes){
		    	 sem.release();
		     }
	    	 
	   }
	   
	   public SemaphoreDemo(){
		   initializeResource();
	   }
 
       private void initializeResource(){
    	   for (int i = 0; i < MAX_COUNT; ++i) {
		      res[i]=new Thread();
		   }
       }
	 }