package com.concurrent.ExecutorFrameworkPractice;
/*
Introducing DemoTask
Adding CustomThreadPoolExecutor
Explaining BlockingQueue
Explaining RejectedExecutionHandler
Testing our code




Adding CustomThreadPoolExecutor:
This is important. Our CustomThreadPoolExecutor is extension of ThreadPoolExecutor. Even without extending the ThreadPoolExecutor,
 simply creating its instance and using it, will also work correctly. But, we will miss some extremely useful features in terms of control of execution.

ThreadPoolExecutor provides two excellent methods which i will highly recommend to override i.e. beforeExecute() and afterExecute() methods. They provide very good handle on execution life cycle of runnables to be executed
 
 
 Explaining BlockingQueue:
 If you remember solving the producer-consumer problem, before JDK 5, consumer had to wait until producer put something in resource queue. This problem can be easily solved using new BlockingQueue.

BlockingQueue is like another Queue implementations with additional capabilities. Any attempt, to retrieve something out of it, can be seen safe as it will not return empty handed. Consumer thread will automatically wait until BlockingQueue is not populated with some data. Once it fills, thread will consume the resource.


 
BlockingQueue works on following rules:

If fewer than corePoolSize threads are running, the Executor always prefers adding a new thread rather than queuing.
If corePoolSize or more threads are running, the Executor always prefers queuing a request rather than adding a new thread.
If a request cannot be queued, a new thread is created unless this would exceed maximumPoolSize, in which case, the task will be rejected.
 
 Explaining RejectedExecutionHandler:
 So the danger is, a task can be rejected as well. We need to have something in place to resolve this situation because no one would like to miss any single job in his application.

Can we do something about it? Yes, we can…[Borrowed from Obama]

BlockingQueue in case of rejection throws RejectedExectionException, we can add a handler for it.

Adding RejectedExecutionHandler is considered a good practice when using new concurrent APIs.
 */
public class DemoThread implements Runnable 
{
    private String name = null;
 
    public DemoThread(String name) {
        this.name = name;
    }
 
    public String getName() {
        return this.name;
    }
 
  
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing : " + name);
    }
}