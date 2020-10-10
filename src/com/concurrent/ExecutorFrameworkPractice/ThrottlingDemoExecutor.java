package com.concurrent.ExecutorFrameworkPractice;


/*
 Throttling task submission rate using ThreadPoolExecutor
 and Semaphore:

If you may know that in web-servers you can configure the maximum number of 
concurrent connections to the server. If more connections than this limit come 
to server, they have to wait until some other connections are freed or closed. 
This limitation can be taken as throttling. Throttling is the capability of
 regulating the rate of input for a system where output rate is slower
 than input. It is necessary to stop the system from crashing or resource exhaustion.
 */

/*In one of my previous post related to BlockingQueue and ThreadPoolExecutor, 
 * We learned about creating a CustomThreadPoolExecutor which had following 
 * capabilities:

1) Tasks being submitted to blocking queue
2) An executor which picks up the task from queue and execute them
3) Had overridden beforeExecute() and afterExecute() methods to perform some
 extra activities if needed
4) Attached a RejectedExecutionHandler which handle the task if it got rejected
 because the queue was full

Our approach was good enough already and capable of handling most of the 
practical scenarios. Now let’s add one more concept into it which may 
prove beneficial in some conditions. This concept is around throttling 
of task submission in queue.


In this example, throttling will help in keeping the number of tasks in
 queue in limit so that no task get rejected. It essentially removes the
  necessity of RejectedExecutionHandler as well.*/
/*Previous Solution Using CustomThreadPoolExecutor with RejectedExecutionHandler
 * 
 * DemoTask Rejected : 71
Executing : 3
Executing : 5
...
...
There will be multiple occurrences of “DemoTask Rejected“. 
In next solution, we will put throttle technique so that no task should be rejected.
 
 * */
/* -----Implemenatation------

Throttling Task submission rate using ThreadPoolExecutor and Semaphore
In this solution, we will create a Semaphore with a number which must be equal to maximum number of tasks in blocking queue at any given point of time. So the approach works like this:

1) Before executing a task a lock in semaphore is requested
2) If lock is acquired then execution works normally; Otherwise retry will happen until lock is acquired
3) Once task is completed; lock is released to semaphore

Our new throttling enabled BlockingThreadPoolExecutor looks like below:

When you run the ThrottlingDemoExecutor program using BlockingThreadPoolExecutor in place 
of CustomThreadPoolExecutor, you will not see any task rejected and all tasks 
will be executed successfully.

You can control the number of tasks executing at any time parameter passes in 
Semaphore constructor.
*/





import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThrottlingDemoExecutor {
	public static void main(String[] args)
	   {
	      Integer threadCounter = 0;
	      BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
	      BlockingThreadPoolExecutor executor = new BlockingThreadPoolExecutor(10, 20, 5000,
	    		                                     TimeUnit.MILLISECONDS, blockingQueue);
	      executor.setRejectedExecutionHandler(new RejectedExecutionHandler()
	         {
	            @Override
	            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
	            {
	               System.out.println("DemoTask Rejected : " + ((DemoThread) r).getName());
	               try
	               {
	                  Thread.sleep(1000);
	               } catch (InterruptedException e)
	               {
	                  e.printStackTrace();
	               }
	               System.out.println("Lets add another time : " + ((DemoThread) r).getName());
	               executor.execute(r);
	            }
	         });
	      // Let start all core threads initially
	      executor.prestartAllCoreThreads();
	      while (true)
	      {
	         threadCounter++;
	         // Adding threads one by one
	         System.out.println("Adding DemoTask : " + threadCounter);
	         executor.execute(new DemoThread(threadCounter.toString()));
	         if (threadCounter == 1000)
	            break;
	      }
	   }
}
