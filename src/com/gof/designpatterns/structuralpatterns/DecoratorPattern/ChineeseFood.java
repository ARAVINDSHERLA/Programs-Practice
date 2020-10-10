package com.gof.designpatterns.structuralpatterns.DecoratorPattern;

/*Step 5:Create a ChineeseFood concrete class that
will extend the FoodDecorator class and override it's
all methods.

File: ChineeseFood.java*/
public class ChineeseFood extends FoodDecorator{  
  public ChineeseFood(Food newFood)    {  
        super(newFood);  
  }  
    public String prepareFood(){  
        return super.prepareFood() +" With Fried Rice and Manchurian  ";   
    }  
    public double foodPrice()   {  
        return super.foodPrice()+65.0;  
        }  
}  