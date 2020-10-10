package com.concurrent.ExecutorFrameworkPractice;

public class TaskTwo implements Runnable {
    public void run() {
        System.out.println("Executing Task Two");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}