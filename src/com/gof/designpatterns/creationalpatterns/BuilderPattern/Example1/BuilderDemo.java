package com.gof.designpatterns.creationalpatterns.BuilderPattern.Example1;

/*
 Builder constructs complex objects by separating construction and representation.
 */


public class BuilderDemo{  
	 public static void main(String args[]){  
	   CDBuilder cdBuilder=new CDBuilder();  
	   CDType cdType1=cdBuilder.buildSonyCD();  
	   cdType1.showItems();  
	  
	   CDType cdType2=cdBuilder.buildSamsungCD();  
	   cdType2.showItems();  
	 }  
	}  