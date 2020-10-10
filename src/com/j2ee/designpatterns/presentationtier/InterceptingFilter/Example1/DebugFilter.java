package com.j2ee.designpatterns.presentationtier.InterceptingFilter.Example1;

public class DebugFilter implements Filter {
	 public void execute(String request){
	 System.out.println("request log: " + request);
	 }
	}

