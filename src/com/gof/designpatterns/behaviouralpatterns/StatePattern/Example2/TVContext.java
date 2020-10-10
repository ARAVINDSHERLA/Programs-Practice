package com.gof.designpatterns.behaviouralpatterns.StatePattern.Example2;
//Context Implementation
public class TVContext implements State {
	 
    private State tvState;
 
    public void setState(State state) {
        this.tvState=state;
    }
 
    public State getState() {
        return this.tvState;
    }
 
    @Override
    public void doAction() {
        this.tvState.doAction();
    }
 
}
/*Notice that Context also implements State and keep a reference of it’s current state and 
forwards the request to the state implementation.*/
