package com.vaannila.helloworld;

public class Immutability {
	
	private String a;
	private String b;
	
	public Immutability(String a ,String b){
		this.a=a;
		this.b=b;
	}
	
	public String getA(){
		return a;
		}
	
	public String getB(){
		return b;
		}
	
	public Object clone(){
	return new 	Immutability(a,b);
	}

}
