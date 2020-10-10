package com.concurrent.ExecutorFrameworkPractice;
/*
 Explaining BlockingQueue

If you remember solving the producer-consumer problem, before JDK 5, consumer had 
to wait until producer put something in resource queue. This problem can be 
easily solved using new BlockingQueue.

BlockingQueue is like another Queue implementations with additional capabilities. 
Any attempt, to retrieve something out of it, can be seen safe as it will 
not return empty handed. Consumer thread will automatically wait until 
BlockingQueue is not populated with some data. Once it fills, thread will 
consume the resource.

BlockingQueue works on following rules:

If fewer than corePoolSize threads are running, the Executor always 
prefers adding a new thread rather than queuing.
If corePoolSize or more threads are running, the Executor always prefers 
queuing a request rather than adding a new thread.
If a request cannot be queued, a new thread is created unless this would 
exceed maximumPoolSize, in which case, the task will be rejected.
 */
/*Explaining RejectedExecutionHandler

So the danger is, a task can be rejected as well. We need to have something in place to resolve this situation because no one would like to miss any single job in his application.

Can we do something about it? Yes, we can…[Borrowed from Obama]

BlockingQueue in case of rejection throws RejectedExectionException, we can add a handler for it.

Adding RejectedExecutionHandler is considered a good practice when using new concurrent APIs.
 */
/*We have some 100 tasks. We want to run them using ideally 10, and maximum 20 threads.
 *  I am 
 * trying to write code as below. You might write it better or you have this solution.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 /*
  Testing the code:
  We have some 100 tasks. We want to run them using ideally 10, and maximum 20 threads. 
  I am trying to write code as below. You might write it better or you have this solution.
  */
public class DemoExecutor 
{
    public static void main(String[] args) 
    {
        Integer threadCounter = 0;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
 
        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,
                                            20, 5000, TimeUnit.MILLISECONDS, blockingQueue);
 
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r,
                    ThreadPoolExecutor executor) {
                System.out.println("DemoTask Rejected : "
                        + ((DemoThread) r).getName());
                System.out.println("Waiting for a second !!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Lets add another time : "
                        + ((DemoThread) r).getName());
                executor.execute(r);
            }
        });
        // Let start all core threads initially
        executor.prestartAllCoreThreads();
        while (true) {
            threadCounter++;
            // Adding threads one by one
            System.out.println("Adding DemoTask : " + threadCounter);
            executor.execute(new DemoThread(threadCounter.toString()));
 
            if (threadCounter == 100)
                break;
        }
    }
 
}
