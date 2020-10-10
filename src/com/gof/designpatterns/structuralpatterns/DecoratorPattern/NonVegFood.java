package com.gof.designpatterns.structuralpatterns.DecoratorPattern;

/*Step 4:Create a NonVegFood concrete class that will 
extend the FoodDecorator class and override it's 
all methods.

File: NonVegFood.java*/
public class NonVegFood extends FoodDecorator{    
    public NonVegFood(Food newFood) {  
        super(newFood);  
    }  
    public String prepareFood(){  
        return super.prepareFood() +" With Roasted Chiken and Chiken Curry  ";   
    }  
    public double foodPrice()   {  
        return super.foodPrice()+150.0;  
    }  
}  