package com.concurrent.ExecutorFrameworkPractice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*
 This is important. Our CustomThreadPoolExecutor is extension of ThreadPoolExecutor. 
 Even without extending the ThreadPoolExecutor, simply creating its instance 
 and using it, will also work correctly. But, we 
 will miss some extremely useful features in terms of control of execution.

ThreadPoolExecutor provides two excellent methods which i will highly
 recommend to override i.e. beforeExecute() and afterExecute() methods. 
 They provide very good handle on execution life cycle of runnables to be 
 executed. Lets see above methods inside our CustomThreadPoolExecutor. 
 */


public class CustomThreadPoolExecutor extends ThreadPoolExecutor {
 
    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
            long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
 
   
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("Perform beforeExecute() logic");
    }
 
   
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            System.out.println("Perform exception handler logic");
        }
        System.out.println("Perform afterExecute() logic");
    }
 
}