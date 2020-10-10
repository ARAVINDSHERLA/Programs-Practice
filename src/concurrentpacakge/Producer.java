package concurrentpacakge;

import java.util.concurrent.BlockingQueue;
/*
 Here is the Producer class. Notice how it 
 sleeps a second between each put() call.
 This will cause the Consumer to block,
  while waiting for objects in the queue.
 */
public class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}