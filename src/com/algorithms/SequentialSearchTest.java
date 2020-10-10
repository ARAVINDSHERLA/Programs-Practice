package com.algorithms;


public class SequentialSearchTest {
public static void main(String[] args)
{
	testContains();	
}
	 
	  public static void testContains() {
	    int[]a = {1, 2, 3, 4, 5, 19, 17,17, 7};
	    System.out.println(SequentialSearch.contains(a, 17));
	    System.out.println(SequentialSearch.contains(a, 1));
	    System.out.println(SequentialSearch.contains(a, 2));
	    System.out.println(SequentialSearch.contains(a, 3));
	    System.out.println(SequentialSearch.contains(a, 4));
	    System.out.println(SequentialSearch.contains(a, 10));
	  }

	} 
