package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


class Person1
{
     String FirstName;
     String LastName;
 
    /* Person1(String fName, String lName)
     {
              FirstName = fName;
              LastName = lName;
      }*/
} 

class Student extends Person1
{
     int id;
     String standard;
     String instructor;
 
     Student(String fName, String lName, int nId, String stnd, String instr)
     {
         // super(fName,lName);
          id = nId;
          standard = stnd;
          instructor = instr;         
      }
}


public class ExampleDemo
{
       public static void main(String args[])
       {
               Student sObj = new Student("Jacob","Smith",1,"1 - B","Roma");
 
               System.out.println("Student :");
               System.out.println("First Name : " + sObj.FirstName);
               System.out.println("Last Name : " + sObj.LastName);
               System.out.println("ID : " + sObj.id);
               System.out.println("Standard : " + sObj.standard);
               System.out.println("Instructor : " + sObj.instructor);
      
               
       
       }
}
 