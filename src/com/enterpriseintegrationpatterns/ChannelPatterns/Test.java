package com.enterpriseintegrationpatterns.ChannelPatterns;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
public static void main(String[] args)
{
	Set a =new HashSet();
	a.add("a");
	a.add("a");
	System.out.println("output:"+a);
	a=new TreeSet();
	a.add("b");
	a.add("a");
	System.out.println("output:"+a);
}
}
