package com.j2ee.designpatterns.presentationtier.InterceptingFilter.Example1;

public class Client {
	 FilterManger filterManager;
	 public void setFilterManager(FilterManger filterManager){
	 this.filterManager = filterManager;
	 }
	 public void sendRequest(String request){
	 filterManager.filterRequest(request);
	 }
	}