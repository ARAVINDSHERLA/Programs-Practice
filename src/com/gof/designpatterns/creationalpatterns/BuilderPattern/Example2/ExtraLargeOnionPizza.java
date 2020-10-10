package com.gof.designpatterns.creationalpatterns.BuilderPattern.Example2;

public class ExtraLargeOnionPizza extends VegPizza {  
    @Override  
    public float price() {  
        return 200.0f;  
    }  
    @Override  
    public String name() {  
         return  "Onion Pizza";  
    }  
    @Override  
    public String size() {  
       return  "Extra-Large Size";  
    }  
}// End of the ExtraLargeOnionPizza class 