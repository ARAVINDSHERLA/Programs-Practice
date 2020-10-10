package com;

/*
Performing Binary Search on Java int Array Example
This java example shows how to perform binary search for an element of
java int array using Arrays class.
*/

import java.util.Arrays;

public class BinarySearchIntArrayExample {

public static void main(String[] args) {
  //create int array
  int intArray[] = {1,2,4,5};
 
  /*
    To perform binary search on int array use
    int binarySearch(int[] b, int value) of Arrays class. This method searches
    the int array for specified int value using binary search algorithm.
   
    Please note that the int array MUST BE SORTED before it can be searched
    using binarySearch method.
   
    This method returns the index of the value to be searched, if found in the
    array.
    Otherwise it returns (- (X) - 1)
    where X is the index where the the search value would be inserted.
    i.e. index of first element that is grater than the search
    value or array.length, if all elements of an array are less than
    the search value.
  */
 
  //sort int array using Arrays.sort method
  Arrays.sort(intArray);
 
  //value to search
  int searchValue = 2;
 
  //since 2 is present in int array, index of it would be returned
  int intResult = Arrays.binarySearch(intArray,searchValue);
  System.out.println("Result of binary search of 2 is : " + intResult);
 
  //lets search something which is not in int array !
  searchValue = 3;
  intResult = Arrays.binarySearch(intArray,searchValue);
  System.out.println("Result of binary search of 3 is : " + intResult);

   int a[]={4,5,6,7,232};
   int intvalue=Arrays.binarySearch(a, 232);
   System.out.println("Result of binary search of 7 is : " + intvalue);
}
}

/*
Output would be
Result of binary search of 2 is : 1
Result of binary search of 3 is : -3
*/
