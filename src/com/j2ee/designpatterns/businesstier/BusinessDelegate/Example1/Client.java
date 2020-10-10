package com.j2ee.designpatterns.businesstier.BusinessDelegate.Example1;

public class Client {
	
	   BusinessDelegate businessService;

	   public Client(BusinessDelegate businessService){
	      this.businessService  = businessService;
	   }

	   public void doTask(){		
	      businessService.doTask();
	   }
	}
