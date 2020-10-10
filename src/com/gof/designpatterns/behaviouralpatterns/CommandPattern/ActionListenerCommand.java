package com.gof.designpatterns.behaviouralpatterns.CommandPattern;


/*
 These are the following participants of the Command Design pattern:

Command: This is an interface for executing an operation.
ConcreteCommand: This class extends the Command interface and implements the execute method. This class creates a binding between the action and the receiver.
Client: This class creates the ConcreteCommand class and associates it with the receiver.
Invoker: This class asks the command to carry out the request.
Receiver: This class knows to perform the operation.
 */


//Create a ActionListernerCommand interface that will act as a Command.

public interface ActionListenerCommand {  
    public void execute();  
}  
