package com.gof.designpatterns.behaviouralpatterns.MediatorPattern.Example1;

public interface IATCMediator {

	public void registerRunway(Runway runway);

	public void registerFlight(Flight flight);

	public boolean isLandingOk();

	public void setLandingStatus(boolean status);
}
