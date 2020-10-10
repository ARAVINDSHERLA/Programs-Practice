package com.gof.designpatterns.structuralpatterns.BridgePattern;

/*Create a QuestionFormat class that will extend the
QuestionManager class*/

//this is the QuestionFormat class.  
public class QuestionFormat extends QuestionManager {  
 public QuestionFormat(String catalog){  
     super(catalog);  
 }  
 public void displayAll() {  
     System.out.println("\n---------------------------------------------------------");  
     super.displayAll();  
     System.out.println("-----------------------------------------------------------");  
 }  
}// End of the QuestionFormat class.