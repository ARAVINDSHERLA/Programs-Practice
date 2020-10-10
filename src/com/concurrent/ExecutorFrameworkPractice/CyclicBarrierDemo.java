package com.concurrent.ExecutorFrameworkPractice;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
 
/*
CyclicBarrier helps in synchronization. Among the threads, all threads waits till
the point , they reach at one barrier point. In the scenario of fixed size
threadpool and each thread usually waits each other, CyclicBarrier can be 
used to handle synchronization. 
Once all the threads released from waiting, the same barrier can be used again and
 again, and that is why this is called as cyclic.
I have taken an example in which I will invoke 3 thread.
Each Thread will do summation for a given start and end value.
All the threads will start working simultaneously and will put value in a list
and will wait till all the threads will reach to a common point 
i.e barrierTest.await(); And then await is released and addListvalue() is called.

*/
public class CyclicBarrierDemo {
 
 final CyclicBarrier barrierTest;
 List list=new ArrayList();
    
 CyclicBarrierDemo(){
  barrierTest = new CyclicBarrier(3,new Runnable() {
               public void run() { 
                addListvalue();  
               }
             });
  new Thread(new Task(1,3)).start();
  new Thread(new Task(4,6)).start();
  new Thread(new Task(7,9)).start();
  }
    
   void  add(int start,int end){
  int sum=0;
  for(int s=start;s<=end;s++){ 
  sum+=s;
  }
  list.add(sum);
  System.out.println("Per Thread Addition:"+sum);
  }
  void addListvalue(){
  int total=0;
  for(int j=0;j<list.size();j++){
  total+=(Integer)list.get(j);
  }
  System.out.println("Total addtion:"+total);
  }
   
  class Task implements Runnable {
  int start=0;
  int end=0;
    Task(int start,int end) {
    this.start = start;
    this.end=end;
    }
    public void run() {
    add(start,end);
        try { 
          barrierTest.await(); 
        } catch (InterruptedException ex) { 
          return; 
        } catch (BrokenBarrierException ex) { 
          return; 
        }
      }
  }
  public static void main(String... args){
new CyclicBarrierDemo();   
  }
}