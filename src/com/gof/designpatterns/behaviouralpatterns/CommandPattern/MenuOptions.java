package com.gof.designpatterns.behaviouralpatterns.CommandPattern;


//Create a MenuOptions class 
//that will act as an Invoker.
public class MenuOptions {
	ActionListenerCommand openDoc;
	ActionListenerCommand saveDoc;
	
   public MenuOptions(ActionListenerCommand openDoc,
		   ActionListenerCommand saveDoc)
   {
	   this.openDoc=openDoc;
	   this.saveDoc=saveDoc;
   }
public void clickOpen() {
	    openDoc.execute();
	
	
}
public void clickSave() {
	// TODO Auto-generated method stub
	saveDoc.execute();
	
}
   
   
}
