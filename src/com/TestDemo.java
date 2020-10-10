package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestDemo {
	public enum Season {winter,spring,summer};//improves readability 
	//& maintainability
	  public static void main(String args[])
        {
		  String value="";
		  String triggerName1="";
		  String triggerName2="";
		  if(value!=null&&value.contains(";")){
			  triggerName1=value.substring(0, value.indexOf(";"));
			  triggerName2=value.substring(value.indexOf(";")+1,value.length());
			  System.out.println("triggerName1="+triggerName1);
			  System.out.println("triggerName2="+triggerName2);	
		  }
		  else{
		     triggerName1=  value;
			System.out.println("else:"+triggerName1);
		  }
		                 
		  
		  
		  
		  
		  
		  Collection<String> c=new ArrayList<String>();
		    c.add("a");
		    c.add("a");
		    c.add("b");
		             HashSet<String> a= new HashSet<String>(c); 
		             System.out.println(a);
		             
		   for (Season ses:Season.values()) 
		   {
			   System.out.println("ses:"+ses);
		   }
		            String name=new String("Aravind");
		            String comp="Aravind";
		            System.out.println((name.intern()==comp)+""+name.equals(comp));
             
}
}
