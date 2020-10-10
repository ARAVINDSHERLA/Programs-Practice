package com.vaannila.helloworld;

public class SingletonDemo {

	
	/*//Eager Instanitation
	 public static SingletonDemo demo=new SingletonDemo();
	
	private SingletonDemo(){};
	
	public static SingletonDemo  getInstance()
	{
		return demo;
	}
	 */
	//Lazy Instanitation
	public static SingletonDemo demo=null;
	
	private SingletonDemo(){};
	
	public static SingletonDemo  getInstance(){
		if(demo==null){
			synchronized(SingletonDemo.class){
				demo=new SingletonDemo();
			}
		}
		return demo;
	}
}
