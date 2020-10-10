package com.gof.designpatterns.behaviouralpatterns.StatePattern.Example2;

public class TVRemote {
	 
    public static void main(String[] args) {
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();
         
        context.setState(tvStartState);
        context.doAction();
         
         
        context.setState(tvStopState);
        context.doAction();
         
    }
 
}
/*
 Output of above program is same as the basic implementation of TV Remote without using any pattern.

The benefits of using State pattern to implement polymorphic behavior is clearly visible, the chances of error are less and it’s very easy to add more states for additional behavior making it more robust, easily maintainable and flexible. Also State pattern helped in avoiding if-else or switch-case conditional logic in this scenario.
 */
