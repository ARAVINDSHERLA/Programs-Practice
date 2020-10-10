package com.gof.designpatterns.behaviouralpatterns.TemplateMethodPattern.Example2;
/*
 Template method design pattern is to define an algorithm as skeleton of operations and leave the details to be implemented by the child classes. The overall structure and sequence of the algorithm is preserved by the parent class.

This behavioral design pattern is one of the easiest to understand and implement. This design pattern is used popularly in framework development. This helps to avoid code duplication also.

Template Method Definition

Template method design pattern has two components. An abstract parent class and one or more concrete child classes extending that parent class. The abstract parent class is the template class used to define the algorithmic steps and preserve it across implementations. 
Child class contains details of the abstract methods.
 */
public abstract class OrderProcessTemplate {
	public boolean isGift;

	public abstract void doSelect();

	public abstract void doPayment();

	public final void giftWrap() {
		System.out.println("Gift wrap done.");
	}

	public abstract void doDelivery();

	public final void processOrder() {
		doSelect();
		doPayment();
		if (isGift) {
			giftWrap();
		}
		doDelivery();
	}
}
