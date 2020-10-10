package com.gof.designpatterns.creationalpatterns.BuilderPattern.Example2;

public abstract class Coke  extends ColdDrink {  
	  
    @Override  
    public abstract  String name();  
  
    @Override  
    public abstract  String size();  
      
    @Override  
    public abstract  float price();   
      
}// End of the Coke class  