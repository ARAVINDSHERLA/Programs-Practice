package com.gof.designpatterns.creationalpatterns.SingletonPattern;

class EarlyInstantiationSingleton{  
	 private static EarlyInstantiationSingleton obj=new EarlyInstantiationSingleton();//Early, instance will be created at load time  
	 private EarlyInstantiationSingleton(){}  
	   
	 public static EarlyInstantiationSingleton getA(){  
	  return obj;  
	 }  
	  
	 public void doSomething(){  
	 //write your code  
	 }  
	}  