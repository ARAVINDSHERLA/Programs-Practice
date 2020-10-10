package com.fundamentals;

import java.util.HashMap;
import java.util.Set;
 /*
  Below example shows how to search user defined objects as a key from HashMap. You can achieve this by implementing equals and hashcode methods at the user defined objects. 
  */
public class MyObjectKeySearch {
 
public static void main(String a[]){
         
        HashMap<Price, String> hm = new HashMap<Price, String>();
        hm.put(new Price("Banana", 20), "Banana");
        hm.put(new Price("Apple", 40), "Apple");
        hm.put(new Price("Orange", 30), "Orange");
        printMap(hm);
        Price key = new Price("Banana", 20);
        System.out.println("Does key available? "+hm.containsKey(key));
    }
     
    public static void printMap(HashMap<Price, String> map){
         
        Set<Price> keys = map.keySet();
        for(Price p:keys){
            System.out.println(p+"==>"+map.get(p));
        }
    }
}
