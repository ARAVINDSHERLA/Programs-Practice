package com;


/*
Swap elements of Java ArrayList example
This java example shows how to swap elements of Java ArrayList object using
swap method of Collections class.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwapArrayListElement {

public static void main(String[] args) {
 
  //create an ArrayList object
  ArrayList arrayList = new ArrayList();
 
  //Add elements to Arraylist
  arrayList.add("A");
  arrayList.add("B");
  arrayList.add("C");
  arrayList.add("D");
  arrayList.add("E");
  
  System.out.println("Before swaping, ArrayList contains : " + arrayList);
 
  /*
    To swap elements of Java ArrayList use,
    static void swap(List list, int firstElement, int secondElement)
    method of Collections class. Where firstElement is the index of first
    element to be swapped and secondElement is the index of the second element
    to be swapped.
   
    If the specified positions are equal, list remains unchanged.
   
    Please note that, this method can throw IndexOutOfBoundsException if
    any of the index values is not in range.
  */
 
  Collections.swap(arrayList,2,0);
 
  System.out.println("After swaping, ArrayList contains : " + arrayList);
  
  /*
  Output:


 true
 [2nd, 3rd, 2nd, 3rd]


  * */

 
     String orig[] = { "1st", "2nd", "3rd", "4th", "5th",
    		 "1st", "2nd", "3rd","4th", "5th" };
    // String act[] = { "2nd", "3rd", "6th" };
     String act[] = { "2nd" };
     List origList = new ArrayList(Arrays.asList(orig));
     List actList = Arrays.asList(act);

     System.out.println(origList.retainAll(actList));
     System.out.println(origList);
     
     //String array
     String[] strDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday"};
    
     /*
      * There are basically two methods, one is to use temporary array and
      * manually loop through the elements of an Array and swap them or to use
      * Arrays and Collections classes.
      *
      * This example uses the second approach i.e. without temp variable.
      *
      */
    
     //first create a list from String array
     List<String> list = Arrays.asList(strDays);
    
     //next, reverse the list using Collections.reverse method
     Collections.reverse(list);
    
     //next, convert the list back to String array
     strDays = (String[]) list.toArray();
    
     System.out.println("String array reversed");
    
     //print the reversed String array
     for(int i=0; i < strDays.length; i++){
             System.out.println(strDays[i]);
     }
   
   
           
 
}
}

/*
Output would be
Before swaping, ArrayList contains : [A, B, C, D, E]
After swaping, ArrayList contains : [E, B, C, D, A]
*/
