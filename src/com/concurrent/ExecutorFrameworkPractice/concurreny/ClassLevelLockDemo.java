package com.concurrent.ExecutorFrameworkPractice.concurreny;

/*Class level locking prevents multiple threads to enter in synchronized 
block in any of all available instances on runtime. 
This means if in runtime there are 100 instances of  DemoClass,
then only one thread will be able to execute demoMethod() in any one 
of instance at a time, and all other instances will be locked for other threads.
This should always be done to make static data thread safe.*/

public class ClassLevelLockDemo
{
    public synchronized static void demoMethod(){}
}
 
//or
 /*
public class DemoClass
{
    public void demoMethod(){
        synchronized (DemoClass.class)
        {
            //other thread safe code
        }
    }
}*/
 
//or
 /*
public class DemoClass
{
    private final static Object lock = new Object();
    public void demoMethod(){
        synchronized (lock)
        {
            //other thread safe code
        }
    }
}*/