package com;
import java.util.*;
public class CollectionsFrameWork {

	public static void main(String[] args){
		ArrayList<String> list=new ArrayList<String>();
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("A");
		list.add("C");
		list.add("C");
		//Collections.shuffle(list);
		//Collections.reverse(list);
		String[] b=new String[]{"A","A","A","B","A","C","C"};
		int c=Arrays.binarySearch(b, "a");
		System.out.println(list +""+c);
	}
	
	
}
