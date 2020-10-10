package com.dell.persistance.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Student extends Person{  
	 String course;  
	 int fee;  
	 public Student(int id, String name, String course, int fee) {  
	  super(id,name);  
	  this.course=course;  
	  this.fee=fee;  
	 }  
	 
	 public static void main(String [] args){
		 Student e = new Student(6,"Aravind","Java",400);
	     try{
	         FileOutputStream fileOut =
	         new FileOutputStream("C:/Aravind/Java Practice WorkSpace/JDBC-Programs/src/com/dell/persistance/Student.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/Student.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	   }
	}  