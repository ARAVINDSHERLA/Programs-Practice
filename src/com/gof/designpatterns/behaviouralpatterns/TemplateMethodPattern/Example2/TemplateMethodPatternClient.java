package com.gof.designpatterns.behaviouralpatterns.TemplateMethodPattern.Example2;

public class TemplateMethodPatternClient {
	public static void main(String... args) {
		System.out.println("$$$$$$$ NetOrder instance of the Template: $$$$$$$");
		OrderProcessTemplate netOrder = new NetOrder();
		netOrder.processOrder();
		System.out.println("$$$$$$$ StoreOrder instance of the Template: $$$$$$$");
		OrderProcessTemplate storeOrder = new StoreOrder();
		storeOrder.processOrder();
	}
}
