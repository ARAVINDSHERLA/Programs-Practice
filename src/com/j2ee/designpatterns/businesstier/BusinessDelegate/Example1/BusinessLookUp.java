package com.j2ee.designpatterns.businesstier.BusinessDelegate.Example1;

public class BusinessLookUp {
	   public BusinessService getBusinessService(String serviceType){
	      if(serviceType.equalsIgnoreCase("EJB")){
	         return new EJBService();
	      }else {
	         return new JMSService();
	      }
	   }
	}
