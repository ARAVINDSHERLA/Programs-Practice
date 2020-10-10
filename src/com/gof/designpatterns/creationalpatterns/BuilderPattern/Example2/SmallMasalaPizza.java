package com.gof.designpatterns.creationalpatterns.BuilderPattern.Example2;

public class SmallMasalaPizza extends VegPizza{  
    @Override  
    public float price() {  
        return 100.0f;  
    }  
    @Override  
    public String name() {  
        return  "Masala Pizza";  
    }  
    @Override  
    public String size() {  
       return  "Samll Size";  
    }  
}// End of the SmallMasalaPizza class  