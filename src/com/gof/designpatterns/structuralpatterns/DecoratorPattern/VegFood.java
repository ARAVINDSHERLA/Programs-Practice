package com.gof.designpatterns.structuralpatterns.DecoratorPattern;

//Step 2: Create a VegFood class that will implements the Food interface and override its all methods.

//File: VegFood.java
public class VegFood implements Food {  
    public String prepareFood(){  
         return "Veg Food";  
    }  
  
        public double foodPrice(){  
        return 50.0;  
    }  
}    