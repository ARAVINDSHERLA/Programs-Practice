package com.j2ee.designpatterns.businesstier.BusinessDelegate.Example1;

public class EJBService implements BusinessService {

	   @Override
	   public void doProcessing() {
	      System.out.println("Processing task by invoking EJB Service");
	   }
	}