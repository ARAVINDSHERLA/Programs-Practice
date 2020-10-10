package com.concurrent.ExecutorFrameworkPractice;




import java.util.concurrent.Callable;
 
public class CallerTask implements Callable<String>{
 
public String call() throws Exception {
String s="Callable Task Run at "+System.currentTimeMillis();
return s;
}
 
}