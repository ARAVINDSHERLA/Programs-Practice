package com.practice;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
public static void main(String[] args){
	Set<String> s =new HashSet<String>();
	s.add("lion");
	s.add("dog");
	String p=new String("lion");
	String q="lion";
	System.out.println("in the output::"+s.contains(p));
	System.out.println(		p.intern()==q.intern());
	System.out.println(		"="+q.intern());
}
}
