package com.gof.designpatterns.behaviouralpatterns.MementoPattern.Example2;


/*
 Memento pattern is implemented with two objects – Originator and Caretaker. Originator is the object whose state needs to be saved and restored and it uses an inner class to save the state of Object. The inner class is called Memento and its private, so that it can’t be accessed from other objects.

Caretaker is the helper class that is responsible for storing and restoring the Originator’s state through Memento object. Since Memento is private to Originator, Caretaker can’t access it and it’s stored as a Object within the caretaker.
 */
public class FileWriterUtil {
	 
    private String fileName;
    private StringBuilder content;
     
    public FileWriterUtil(String file){
        this.fileName=file;
        this.content=new StringBuilder();
    }
     
    @Override
    public String toString(){
        return this.content.toString();
    }
     
    public void write(String str){
        content.append(str);
    }
     
    public Memento save(){
        return new Memento(this.fileName,this.content);
    }
     
    public void undoToLastSave(Object obj){
        Memento memento = (Memento) obj;
        this.fileName= memento.fileName;
        this.content=memento.content;
    }
     
     
    private class Memento{
        private String fileName;
        private StringBuilder content;
         
        public Memento(String file, StringBuilder content){
            this.fileName=file;
            //notice the deep copy so that Memento and FileWriterUtil content variables don't refer to same object
            this.content=new StringBuilder(content);
        }
    }
}