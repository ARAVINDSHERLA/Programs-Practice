package com.gof.designpatterns.structuralpatterns.ProxyPattern;


/*Create a RealInternetAccess class that will 
 * implement OfficeInternetAccess interface for 
 * granting the permission to the specific employee.
 

File: RealInternetAccess.java*/
public class RealInternetAccess implements OfficeInternetAccess {  
    private String employeeName;  
    public RealInternetAccess(String empName) {  
        this.employeeName = empName;  
    }  
    @Override  
    public void grantInternetAccess() {  
        System.out.println("Internet Access granted for employee: "+ employeeName);  
    }  
}  