package com.j2ee.designpatterns.presentationtier.FrontController.Example1;

public class FrontControllerPatternDemo {
	 public static void main(String[] args) {
	 FrontController frontController = new FrontController();
	 frontController.dispatchRequest("HOME");
	 frontController.dispatchRequest("STUDENT");
	 }
	}

/*

Strategies

Servlet Front Strategy
JSP Front Strategy
Command and Controller Strategy
Physical Resource Mapping Strategy
Logical Resource Mapping Strategy
Dispatcher in Controller Strategy
Base Front Strategy
Filter Controller Strategy
Consequences

Centralizes control
Improves manageability
Improves reusability
Improves role separation




*/