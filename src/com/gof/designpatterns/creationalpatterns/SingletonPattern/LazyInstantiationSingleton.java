package com.gof.designpatterns.creationalpatterns.SingletonPattern;


class LazyInstantiationSingleton{  
	 private static LazyInstantiationSingleton obj;  
	 private LazyInstantiationSingleton(){}  
	   
	 public static LazyInstantiationSingleton getA(){  
	   if (obj == null){  
	      synchronized(LazyInstantiationSingleton.class){  
	        //if (obj == null){  
	            obj = new LazyInstantiationSingleton();//instance will be created at request time  
	        //}  
	    }              
	    }  
	  return obj;  
	 }  
	  
	 public void doSomething(){  
	 //write your code  
	 }  
	}


/*Significance of Serialization in Singleton Pattern

If singleton class is Serializable, you can serialize the singleton instance. Once it is serialized, you can deserialize it but it will not return the singleton object.

To resolve this issue, you need to override the readResolve() method that enforces the singleton. It is called just after the object is deserialized. It returns the singleton object.

public class A implements Serializable {  
        //your code of singleton  
        protected Object readResolve() {  
            return getA();  
        }  
  
    }  */