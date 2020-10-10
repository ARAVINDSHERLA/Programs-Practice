package com.j2ee.designpatterns.presentationtier.InterceptingFilter.Example1;

public class AuthenticationFilter implements Filter {
	 public void execute(String request){
	 System.out.println("Authenticating request: " + request);
	 }
	}
