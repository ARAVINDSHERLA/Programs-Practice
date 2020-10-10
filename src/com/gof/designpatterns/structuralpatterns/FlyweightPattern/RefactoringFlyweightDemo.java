package com.gof.designpatterns.structuralpatterns.FlyweightPattern;
/*
 In this refactoring, the "row" state is considered shareable (within each row anyways), and the "col" state has been externalized (it is supplied by the client when report() is called).
 */
class Gazillion1 {
	   private int row;
	   public Gazillion1( int theRow ) {
	      row = theRow;
	      System.out.println( "ctor: " + row );
	   }
	   void report( int theCol ) {
	      System.out.print( " " + row + theCol );
	}  }

	class Factory {
	   private Gazillion1[] pool;
	   public Factory( int maxRows ) {
	      pool = new Gazillion1[maxRows];
	   }
	   public Gazillion1 getFlyweight( int theRow ) {
	      if (pool[theRow] == null)
	         pool[theRow] = new Gazillion1( theRow );
	      return pool[theRow];
	}  }

	public class RefactoringFlyweightDemo {
	   public static final int ROWS = 6, COLS = 10;

	   public static void main( String[] args ) {
	      Factory theFactory = new Factory( ROWS );
	      for (int i=0; i < ROWS; i++) {
	         for (int j=0; j < COLS; j++)
	            theFactory.getFlyweight( i ).report( j );
	         System.out.println();
	}  }  }