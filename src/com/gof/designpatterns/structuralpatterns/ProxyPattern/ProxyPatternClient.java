package com.gof.designpatterns.structuralpatterns.ProxyPattern;


/*Now, Create a ProxyPatternClient class that can access the internet actually.

File: ProxyPatternClient.java*/
public class ProxyPatternClient {  
    public static void main(String[] args)   
    {  
        OfficeInternetAccess access = new ProxyInternetAccess("Ashwani Rajput");  
        access.grantInternetAccess();  
    }  
}  