package com.concurrent.ExecutorFrameworkPractice.concurreny;

/*
 * 
 * Object level locking is mechanism when you want to synchronize a
 * non-static method or non-static code block such that only one thread 
 * will be able to execute the code block on given instance of the class. 
 * This should always be done to make instance level data thread safe. 
 * 
 */
public class ObjectLevelLockDemo
{
    public synchronized void demoMethod(){}
}
 
// or also//
 /*
public class ObjectLevelLockDemo
{
    public void demoMethod(){
        synchronized (this)
        {
            //other thread safe code
        }
    }
}
 */
//or also//
/* 
public class ObjectLevelLockDemo
{
    private final Object lock = new Object();
    public void demoMethod(){
        synchronized (lock)
        {
            //other thread safe code
        }
    }
}*/