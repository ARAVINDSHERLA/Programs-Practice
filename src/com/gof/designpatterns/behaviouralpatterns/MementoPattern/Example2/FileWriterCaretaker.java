package com.gof.designpatterns.behaviouralpatterns.MementoPattern.Example2;
/*
 Notice the Memento inner class and implementation of 
 save and undo methods. Now we can continue to 
 implement Caretaker class.
 */
public class FileWriterCaretaker {
	 
    private Object obj;
     
    public void save(FileWriterUtil fileWriter){
        this.obj=fileWriter.save();
    }
     
    public void undo(FileWriterUtil fileWriter){
        fileWriter.undoToLastSave(obj);
    }
}
/*Notice that caretaker object contains the saved state in the form of Object, so it can’t alter its data and also it has no knowledge of it’s structure.*/
