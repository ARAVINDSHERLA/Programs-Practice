package com.j2ee.designpatterns.presentationtier.InterceptingFilter.Example1;

public class FilterManger {
	 FilterChain filterChain;
	 public FilterManger(Target target){
	 filterChain = new FilterChain();
	 filterChain.setTarget(target);
	 }
	 public void setFilter(Filter filter){
	 filterChain.addFilter(filter);
	 }
	 public void filterRequest(String request){
	 filterChain.execute(request);
	 }
	}