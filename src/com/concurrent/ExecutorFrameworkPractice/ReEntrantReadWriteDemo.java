package com.concurrent.ExecutorFrameworkPractice;

/*
 ReentrantReadWriteLock implements ReadWriteLock which has both type of lock read
  lock and write lock. More than one thread can apply read lock simultaneously but 
  write lock can be applied by one thread at one time. As an example of lock is 
  that collection that is being accessed by more than one thread may need to modify
   the collection frequently. So threads will need to apply locks on that collection
    object. ReadWriteLock has only two method readLock and writeLock. readLock() 
 is used for reading and writeLock() is used for writing. 
 ReentrantReadWriteLock has the following properties.
	ReentrantReadWriteLock has no preferences over the selection of readLock and writeLock. 
readLock cannot be acquired until all writeLock is released. 
	It is possible to downgrade writeLock to readLock but vice-versa is not possible. 

Find the example of ReentrantReadWriteLock in a custom bean in concurrent environment.
 Lets we have a MyBean class in which we have methods like add, get and delete.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
 
public class ReEntrantReadWriteDemo {
	
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();
	
	private String data;
 
	public String getData() {
		r.lock();
		try{
		    return data;
		}finally{
			r.unlock(); 
		}
	}
 
	public void setData(String data) {
		w.lock();
		try{
		   this.data = data;
		}finally{
			w.unlock();
		}
	}
	   
}