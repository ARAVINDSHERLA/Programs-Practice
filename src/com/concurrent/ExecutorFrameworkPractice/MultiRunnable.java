package com.concurrent.ExecutorFrameworkPractice;

import java.util.List;
//MultiRunnable Wrapper
//create out multi runnable wrapper of above Tasks.
public class MultiRunnable implements Runnable {
 
    private final List<Runnable> runnables;
 
    public MultiRunnable(List<Runnable> runnables) {
        this.runnables = runnables;
    }
    
    public void run() {
        for (Runnable runnable : runnables) {
             new Thread(runnable).start();
        }
    }
}
