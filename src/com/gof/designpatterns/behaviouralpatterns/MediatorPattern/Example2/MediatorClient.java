package com.gof.designpatterns.behaviouralpatterns.MediatorPattern.Example2;

/*Mediator Pattern Client

Let’s test this our chat application with a simple program where we will create mediator and add users to the group and one of the user will send a message.
*/

 
public class MediatorClient {
 
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "Pankaj");
        User user2 = new UserImpl(mediator, "Lisa");
        User user3 = new UserImpl(mediator, "Saurabh");
        User user4 = new UserImpl(mediator, "David");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
         
        user1.send("Hi All");
         
    }
 
}
//Notice that client program is very simple and it has no idea how the message is getting handled and if mediator is getting user or not.
