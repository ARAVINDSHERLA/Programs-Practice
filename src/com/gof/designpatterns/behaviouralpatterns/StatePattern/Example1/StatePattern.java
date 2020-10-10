package com.gof.designpatterns.behaviouralpatterns.StatePattern.Example1;

public class StatePattern {
	public static void main(String[] args) {
		AlertStateContext stateContext = new AlertStateContext();
		stateContext.alert();
		stateContext.alert();
		stateContext.setState(new Silent());
		stateContext.alert();
		stateContext.alert();
		stateContext.alert();		
	}
}
