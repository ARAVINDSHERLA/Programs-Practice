package com.concurrent.ExecutorFrameworkPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
 /*
  Exchanger class in available from jdk1.5. Exchanger class in java exchanges 
  objects between the threads at any synchronization point. 
  The class Exchanger has only one method i.e exchange. Exchange method accepts the 
  object as argument and returns the object. Find the example for better understanding.
  */
public class ExchangeDemo {
 
      Exchanger exchanger = new Exchanger();
	  List  exchnagerList= new ArrayList();
	   class AddList implements Runnable {
	     public void run() {
	       try {
	         while (true) {
	        	 exchnagerList.add("1");
	           if (exchnagerList.size()==1){
	        	   
	        	   exchnagerList = (List) exchanger.exchange(exchnagerList);
	        	   
	           }
	         }
	       } catch (InterruptedException ex) { System.out.println(ex); }
	     }
	   }
	   class SubtractList implements Runnable {
	     public void run() {
	       try {
	         while (true) {
	        	 exchnagerList.remove("1");
	        	 if (exchnagerList.size()==0){
	        	   exchnagerList = (List) exchanger.exchange(exchnagerList);
	        	   
	           }
	         }
	       } catch (InterruptedException ex) { System.out.println(ex);}
	     }
	   }
	   public static void main(String... args) {
	     
	     new Thread((new ExchangeDemo()).new SubtractList()).start();
	     new Thread((new ExchangeDemo()).new AddList()).start();
	   }
	 }