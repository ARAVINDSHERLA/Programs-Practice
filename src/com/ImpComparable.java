package com;

import java.util.Iterator;
import java.util.TreeSet;


 
class Dog implements Comparable<Dog>{
	int size;
 
	Dog(int s) {
		size = s;
	}
 
	@Override
	public int compareTo(Dog o) {
		if (this.size > o.size) {
			return 1;
		} else if (this.size  < o.size) {
			return -1;
		} else {
			return 0;
		}
	}
}
 
public class ImpComparable {
	public static void main(String[] args) {
		TreeSet<Dog> d = new TreeSet<Dog>();
		d.add(new Dog(1));
		d.add(new Dog(2));
		d.add(new Dog(1));
		Iterator i=d.iterator();
		while(i.hasNext())
		{
		System.out.println(((Dog)i.next()).size);
		}
	}
}