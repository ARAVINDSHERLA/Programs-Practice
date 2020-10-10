package com.concurrent.ExecutorFrameworkPractice;

public class TaskOne implements Runnable {
   
    public void run() {
        System.out.println("Executing Task One");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
