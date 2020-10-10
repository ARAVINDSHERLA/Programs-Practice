package com.gof.designpatterns.behaviouralpatterns.CommandPattern;
/*
Create a ActionSave class that will act as an
ConcreteCommand.

File: AdapterPatternDemo.java*/
public class ActionSave implements ActionListenerCommand{  
   private Document doc;  
   public ActionSave(Document doc) {  
        this.doc = doc;  
    }  
    @Override  
    public void execute() {  
        doc.save();  
    }  
}  