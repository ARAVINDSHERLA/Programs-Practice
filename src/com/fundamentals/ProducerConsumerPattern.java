package com.fundamentals;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerPattern {

    public static void main(String args[]){
  
     //Creating shared object
     BlockingQueue sharedQueue = new LinkedBlockingQueue();
 
     //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new Producer1(sharedQueue));
     Thread consThread = new Thread(new Consumer1(sharedQueue));

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }
 
}

//Producer Class in java
class Producer1 implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer1(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

//Consumer Class in Java
class Consumer1 implements Runnable{

    private final BlockingQueue sharedQueue;

    public Consumer1 (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
  
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
  
}

/*
 Producer Consumer Problem in Multi-threading

Producer-Consumer Problem is also a popular java interview question where interviewer ask to implement producer consumer design pattern so that Producer should wait if Queue or bucket is full and Consumer should wait if queue or
bucket is empty. This problem can be implemented or solved by different ways in Java, classical way is using wait and notify method to communicate between Producer and Consumer thread and blocking each of them on individual condition like full queue and empty queue. With introduction of BlockingQueue Data Structure in Java 5 Its now much simpler because BlockingQueue provides this control implicitly by introducing blocking methods put() and take(). Now you don't require to use wait and notify to communicate between Producer and Consumer. BlockingQueue put() method will block if Queue is full in case of Bounded Queue and take() will block if Queue is empty. In next section we will see a code example of Producer Consumer design pattern.


*/

/*
 * Using Blocking Queue to implement Producer Consumer Pattern

BlockingQueue amazingly simplifies implementation of Producer-Consumer design pattern by providing outofbox support of blocking on put() and take(). Developer doesn't need to write confusing and critical piece of wait-notify code to implement communication. BlockingQuue is an interface and Java 5 provides different implantation like ArrayBlockingQueue and LinkedBlockingQueue , both implement FIFO order or elements, while ArrayLinkedQueue is bounded in nature LinkedBlockingQueue is optionally bounded. here is a complete code example of Producer Consumer pattern with BlockingQueue. Compare it with classic wait notify code, its much simpler and easy to understand.



 */
