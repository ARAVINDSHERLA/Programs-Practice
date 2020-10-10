package com.concurrent.ExecutorFrameworkPractice;
/*
 CopyOnWriteArraySet is available from jdk1.5 . CopyOnWriteArraySet is thread safe.
  The behavior of CopyOnWriteArraySet is whenever we are doing mutative operations 
  like add or remove, it copies the elements from the Arrayset. So It is costly.
We should use CopyOnWriteArraySet when we need lesser number of size of ArrayList
and that should be thread safe.
  While iterating the elements of CopyOnWriteArraySet, we cannot remove the elements.
 */
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
public class CopyOnWriteArraySetDemo {
	private final CopyOnWriteArraySet<String> cwas = 
		new CopyOnWriteArraySet<String>();
	public static void main(String... args){
		CopyOnWriteArraySetDemo ob= new CopyOnWriteArraySetDemo();
		ob.cwas.add("A");
		new Thread(ob.new modifyThread()).start();
		new Thread(ob.new modifyThread()).start();
	}
	
	class modifyThread implements Runnable {
 
		
		public void run() {
			Iterator<String> itr= cwas.iterator();
			String s=itr.next();
			cwas.removeAll(cwas);
			cwas.add(s+"A");
			itr= cwas.iterator();
			System.out.println(itr.next());
		}
		
	}
}




