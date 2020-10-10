package com.dell.persistance.serializable;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Student1 implements Serializable{  
 int id;  
 String name;  
 Address address;//HAS-A  
 public Student1(int id, String name,Address b) {  
  this.id = id;  
  this.name = name;  
  this.address=b;
 }  
 public Student1(int id, String name) {  
	  this.id = id;  
	  this.name = name;  
	  
	 } 
 public static void main(String [] args){
	 Address b=new Address("addressLine","city","state");
	// Student1 e = new Student1(10,"Aravind",b);//java.io.NotSerializableException: com.dell.persistance.Address
	 Student1 e=new Student1(101,"testing");
	// e.address=b;
	 try{
         FileOutputStream fileOut =
         new FileOutputStream("C:/Aravind/Java Practice WorkSpace/JDBC-Programs/src/com/dell/persistance/Student1.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /tmp/Student1.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }

}