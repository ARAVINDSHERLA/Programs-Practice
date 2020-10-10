package com.gof.designpatterns.creationalpatterns.SingletonPattern;


public class SingletonDemo {
	 
    private static SingletonDemo instance;
 
       public synchronized static SingletonDemo getInstance()
       {
           if (instance==null)
           {
              instance = new SingletonDemo();
              System.out.println("AccountCreation Class Object creatred...!!!");
           }
          else{
              System.out.println("AccountCreation Class Object not Creatred just returned Created one...!!!");
          }
              return instance;
       }
 
       public void create(int no)
       {
          System.out.println("Account Created Successfully, with Number:" +no);
       }
 
}
