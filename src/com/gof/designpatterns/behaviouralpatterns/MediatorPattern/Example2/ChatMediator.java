package com.gof.designpatterns.behaviouralpatterns.MediatorPattern.Example2;
/*
 * 
 * First of all we will create Mediator interface that will 
 * define the contract for concrete mediators.
 */
public interface ChatMediator {
	 
    public void sendMessage(String msg, User user);
 
    void addUser(User user);
}
