package com.gof.designpatterns.behaviouralpatterns.VisitorPattern;
/*
 Visitor Design Pattern
Intent

Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.
The classic technique for recovering lost type information.
Do the right thing based on the type of two objects.
Double dispatch
 */
import java.util.*;

interface Component { void traverse(); }

class Leaf implements Component {
  private int number;
  public Leaf( int num ) { number = num; }
  public void traverse() { System.out.print( number + " " ); }
}

class Composite implements Component {
  private static char next = 'a';
  private List children = new ArrayList();
  private char letter = next++;

  public void add( Component c ) { children.add( c ); }
  public void traverse() {
    System.out.print( letter + " " );
    for (int i=0; i < children.size(); i++)
      ((Component)children.get(i)).traverse();
} }

public class VisitorComposite1 {
  public static void main( String[] args ) {
    Composite[] containers = new Composite[3];

    for (int i=0; i < containers.length; i++) {
      containers[i] = new Composite();
      for (int j=1; j < 4; j++)
        containers[i].add( new Leaf( i * containers.length + j ) );
    }

    for (int i=1; i < containers.length; i++)
      containers[0].add( containers[i] );

    containers[0].traverse();
    System.out.println();
} }
