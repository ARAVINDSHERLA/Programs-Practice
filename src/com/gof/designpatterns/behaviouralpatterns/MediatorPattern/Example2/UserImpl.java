package com.gof.designpatterns.behaviouralpatterns.MediatorPattern.Example2;

/*
 Concrete Colleague

Now we can create concrete User classes to be used by client system
 */

public class UserImpl extends User {
	 
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }
 
    @Override
    public void send(String msg){
        System.out.println(this.name+": Sending Message="+msg);
        mediator.sendMessage(msg, this);
    }
    @Override
    public void receive(String msg) {
        System.out.println(this.name+": Received Message:"+msg);
    }
 
}
//Notice that send() method is using mediator to send the message to the users and it has no idea how it will be handled by the mediator.


