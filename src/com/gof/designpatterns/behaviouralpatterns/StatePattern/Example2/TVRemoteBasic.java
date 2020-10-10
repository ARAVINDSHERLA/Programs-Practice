package com.gof.designpatterns.behaviouralpatterns.StatePattern.Example2;
/*
 State design pattern is used when an Object change it’s behavior based on it’s internal state.

If we have to change the behavior of an object based on it’s state, we can have a state variable in the Object and use if-else condition block to perform different actions based on the state. State pattern is used to provide a systematic and lose-coupled way to achieve this through Context and State implementations.

Context is the class that has a State reference to one of the concrete implementations of the State and forwards the request to the state object for processing. Let’s understand this with a simple example.
 */
public class TVRemoteBasic {
	 
    private String state="";
     
    public void setState(String state){
        this.state=state;
    }
     
    public void doAction(){
        if(state.equalsIgnoreCase("ON")){
            System.out.println("TV is turned ON");
        }else if(state.equalsIgnoreCase("OFF")){
            System.out.println("TV is turned OFF");
        }
    }
 
    public static void main(String args[]){
        TVRemoteBasic remote = new TVRemoteBasic();
         
        remote.setState("ON");
        remote.doAction();
         
        remote.setState("OFF");
        remote.doAction();
    }
 
}

/*
Notice that client code should know the specific values to use for setting the state of remote, further more if number of states increase then the tight coupling between implementation and the client code will be very hard to maintain and extend.

Now we will use State pattern to implement above TV Remote example.



*/