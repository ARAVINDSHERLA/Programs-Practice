package com.dell.persistance.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeHASAInheritanceDemo {
	 public static void main(String [] args){
	      Student1 e = null;
	      try{
	         FileInputStream fileIn = 
	        		 new FileInputStream("C:/Aravind/Java Practice WorkSpace/JDBC-Programs/src/com/dell/persistance/Student1.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Student1) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Student class not found");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println("Deserialized Student...");
	      System.out.println("Name: " + e.name);
	      System.out.println("id: " + e.id);
	      System.out.println("fee: " +((Address) e.address));
	     
	    }

}
