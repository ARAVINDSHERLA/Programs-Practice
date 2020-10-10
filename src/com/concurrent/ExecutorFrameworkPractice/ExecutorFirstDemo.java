package com.concurrent.ExecutorFrameworkPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class ExecutorFirstDemo {
 
/**
* @param args
*/
public static void main(String[] args) {
// Step1 : Create a Runnable
Runnable simpleTask = new SimpleTask();
// Step 2: Configure Executor
// Uses FixedThreadPool executor
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(simpleTask);
executor.shutdown();
 
}
 
}