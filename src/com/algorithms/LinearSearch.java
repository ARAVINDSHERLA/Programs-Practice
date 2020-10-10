package com.algorithms;
/*
 Java Search Algorithms
Search algorithm is an algorithm for finding an item with specified properties among a collection of items. The items may be stored individually as records in a database or may be elements of a search space defined by a mathematical formula or procedure, such as the roots of an equation with integer variables or a combination of the two.

You can find examples for different types of search algorithms here.

Java Search Algorithms Examples
Write a program to implement Linear search or Sequential search algorithm.
Implement Binary search in java using divide and conquer technique.
Implement Binary search in java using recursive algorithm
- See more at: http://java2novice.com/java-search-algorithms/#sthash.uJi0uRI5.dpuf 
 */
/*
 Program: Write a program to implement Linear search or Sequential search algorithm.

Linear search or sequential search is a method for finding a particular value in a list, that consists of checking every one of its elements, one at a time and in sequence, until the desired one is found.

Linear search is the simplest search algorithm. For a list with n items, the best case is when the value is equal to the first element of the list, in which case only one comparison is needed. The worst case is when the value is not in the list (or occurs only once at the end of the list), in which case n comparisons are needed.

The worst case performance scenario for a linear search is that it has to loop through the entire collection, either because the item is the last one, or because the item is not found. In other words, if you have N items in your collection, the worst case scenario to find an item is N iterations. In Big O Notation it is O(N). The speed of search grows linearly with the number of items within your collection.

Linear searches don't require the collection to be sorted.

- See more at: http://java2novice.com/java-search-algorithms/linear-search/#sthash.25AuYaau.dpuf
 */
public class LinearSearch { 
	public static int linerSearch(int[] arr, int key)
	{ int size = arr.length; 
	for(int i=0;i<size;i++){ 
		if(arr[i] == key){
			return i; 
			} 
		}
	return -1; 
	} 
	public static void main(String a[]){ 
		int[] arr1= {23,45,21,55,234,1,34,90};
		int searchKey = 34;
		System.out.println("Key "+searchKey+" found at index: "+linerSearch(arr1, searchKey));
		int[] arr2= {123,445,421,595,2134,41,304,190};
		searchKey = 421; 
		System.out.println("Key "+searchKey+" found at index: "+linerSearch(arr2, searchKey));
		} 
	} 