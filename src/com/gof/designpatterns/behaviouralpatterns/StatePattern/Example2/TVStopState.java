package com.gof.designpatterns.behaviouralpatterns.StatePattern.Example2;

public class TVStopState implements State {
	 
    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }
 
}
/*Now we are ready to implement our Context object 
that will change it’s 
behavior based on it’s internal state.*/