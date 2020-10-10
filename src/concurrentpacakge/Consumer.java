package concurrentpacakge;

import java.util.concurrent.BlockingQueue;
/*
 Here is the Consumer class. It just takes 
 out the objects from 
 the queue, and prints them to System.out 
 */
public class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}