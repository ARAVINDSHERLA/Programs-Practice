package com.fundamentals;

/*
 SynchronousQueue is special kind of BlockingQueue in which each insert operation must wait for a
  corresponding remove operation by another thread, and vice versa. When you call put() method 
 on SynchronousQueue it blocks until another thread is there to take that element out of the Queue. 
 */
/*
SynchronousQueue, which guarantees that the thread inserting data will block until there is a 
thread to remove that data or vice-versa. 
You can test the other part of code by commenting producer. start(); and only starting consumer thread.

*/
import java.util.concurrent.SynchronousQueue;

/**
 * Java Program to solve Producer Consumer problem using SynchronousQueue. A
 * call to put() will block until there is a corresponding thread to take() that
 * element.
 *
 * @author Javin Paul
 */
public class SynchronousQueueDemo{

    public static void main(String args[]) {

        final SynchronousQueue<String> queue = new SynchronousQueue<String>();

        Thread producer = new Thread("PRODUCER") {
            public void run() {
                String event = "FOUR";
                try {
                    queue.put(event); // thread will block here
                    System.out.printf("[%s] published event : %s %n", Thread
                            .currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        producer.start(); // starting publisher thread

        Thread consumer = new Thread("CONSUMER") {
            public void run() {
                try {
                    String event = queue.take(); // thread will block here
                    System.out.printf("[%s] consumed event : %s %n", Thread
                            .currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        consumer.start(); // starting consumer thread

    }

}
