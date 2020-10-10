package com.algorithms;

public class SequentialSearch {
	  public static boolean contains(int[] a, int b){
	    for (int i : a) {
	      if (i==b){
	        return true;
	      }
	    }
	    return false; 
	  }
	} 
