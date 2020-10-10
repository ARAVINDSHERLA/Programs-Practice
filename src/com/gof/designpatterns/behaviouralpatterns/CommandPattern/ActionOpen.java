package com.gof.designpatterns.behaviouralpatterns.CommandPattern;

/*Create a ActionOpen class that will act as an 
ConcreteCommand.

File: ActionOpen.java*/
public class ActionOpen implements ActionListenerCommand{  
    private Document doc;  
    public ActionOpen(Document doc) {  
        this.doc = doc;  
    }  
    @Override  
    public void execute() {  
        doc.open();  
    }  
}  