package com.gof.designpatterns.creationalpatterns.SingletonPattern;

public class Client {
	 
	  public static void main(String[] args)
	  {
	 
		  SingletonDemo tc = SingletonDemo.getInstance();
		  SingletonDemo tc1 = SingletonDemo.getInstance();
		  tc.create(12345);
	      tc1.create(67891);
	 
	  }
	}