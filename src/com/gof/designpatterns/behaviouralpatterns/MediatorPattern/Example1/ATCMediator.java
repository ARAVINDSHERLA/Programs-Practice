package com.gof.designpatterns.behaviouralpatterns.MediatorPattern.Example1;

/*
In a mediator design pattern implementation we will have

mediator interface – an interface that defines the communication rules between objects
concrete mediator – a mediator object which will enables communication between participating objects
colleague – objects communicating with each other through mediator object
 */

public class ATCMediator implements IATCMediator {
	private Flight flight;
	private Runway runway;
	public boolean land;

	public void registerRunway(Runway runway) {
		this.runway = runway;
	}

	public void registerFlight(Flight flight) {
		this.flight = flight;
	}

	public boolean isLandingOk() {
		return land;
	}

	@Override
	public void setLandingStatus(boolean status) {
		land = status;

	}
}