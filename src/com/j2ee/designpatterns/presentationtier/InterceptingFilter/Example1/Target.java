package com.j2ee.designpatterns.presentationtier.InterceptingFilter.Example1;

public class Target {
	 public void execute(String request){
	 System.out.println("Executing request: " + request);
	 }
	}
