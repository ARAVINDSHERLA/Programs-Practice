package com.gof.designpatterns.creationalpatterns.BuilderPattern.Example2;

public abstract class VegPizza extends Pizza{  
    @Override  
    public abstract float price();  
    @Override  
    public abstract  String name();  
    @Override  
    public abstract  String size();  
}// End of the abstract class VegPizza.  