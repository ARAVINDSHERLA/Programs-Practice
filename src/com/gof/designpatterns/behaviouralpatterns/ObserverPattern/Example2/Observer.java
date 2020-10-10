package com.gof.designpatterns.behaviouralpatterns.ObserverPattern.Example2;

/*
 Next we will create contract for Observer, there will be a method to attach the Subject to the observer and another 
 method to be used by Subject to notify of any change.
 */

public interface Observer {
    
    //method to update the observer, used by subject
    public void update();
     
    //attach with subject to observe
    public void setSubject(Subject sub);
}
/*
 Now our contract is ready, let’s proceed with the concrete implementation of our topic. 
 */
