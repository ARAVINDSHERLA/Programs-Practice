package com.gof.designpatterns.structuralpatterns.CompositePattern;


/*Create an Employee interface that will be treated as 
a component.*/

//this is the Employee interface i.e. Component.  
public interface Employee {  
 public  int getId();  
 public String getName();  
 public double getSalary();  
    public void print();  
 public void add(Employee employee);  
    public void remove(Employee employee);  
    public Employee getChild(int i);  
}// End of the Employee interface.  