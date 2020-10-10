package com.j2ee.designpatterns.presentationtier.FrontController.Example1;

public class Dispatcher {
	 private StudentView studentView;
	 private HomeView homeView;
	 public Dispatcher(){
	 studentView = new StudentView();
	 homeView = new HomeView();
	 }
	 public void dispatch(String request){
	 if(request.equalsIgnoreCase("STUDENT")){
	 studentView.show();
	 }else{
	 homeView.show();
	 }
	 }
	}

