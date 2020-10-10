package com.gof.designpatterns.behaviouralpatterns.MementoPattern.Example3;

/*
 An unlimited "undo" and "redo" capability can be readily implemented with a stack of Command objects and a stack of Memento objects.

The Memento design pattern defines three distinct roles:

Originator - the object that knows how to save itself.
Caretaker - the object that knows why and when the Originator needs to save and restore itself.
Memento - the lock box that is written and read by the Originator, and shepherded by the Caretaker.
 */



import java.util.*;

class Memento {
   private String state;

   public Memento(String stateToSave) { state = stateToSave; }
   public String getSavedState() { return state; }
}

class Originator {
   private String state;
   /* lots of memory consumptive private data that is not necessary to define the 
    * state and should thus not be saved. Hence the small memento object. */

   public void set(String state) { 
       System.out.println("Originator: Setting state to "+state);
       this.state = state; 
   }

   public Memento saveToMemento() { 
       System.out.println("Originator: Saving to Memento.");
       return new Memento(state); 
   }
   public void restoreFromMemento(Memento m) {
       state = m.getSavedState(); 
       System.out.println("Originator: State after restoring from Memento: "+state);
   }
}   

class Caretaker {
   private ArrayList<Memento> savedStates = new ArrayList<Memento>();

   public void addMemento(Memento m) { savedStates.add(m); }
   public Memento getMemento(int index) { return savedStates.get(index); }
}   

public class MementoExample {
   public static void main(String[] args) {
       Caretaker caretaker = new Caretaker();

       Originator originator = new Originator();
       originator.set("State1");
       originator.set("State2");
       caretaker.addMemento( originator.saveToMemento() );
       originator.set("State3");
       caretaker.addMemento( originator.saveToMemento() );
       originator.set("State4");

       originator.restoreFromMemento( caretaker.getMemento(1) );
   }
}