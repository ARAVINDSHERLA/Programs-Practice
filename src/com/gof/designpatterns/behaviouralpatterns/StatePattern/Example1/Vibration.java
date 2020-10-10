package com.gof.designpatterns.behaviouralpatterns.StatePattern.Example1;

public class Vibration implements MobileAlertState {

	@Override
	public void alert(AlertStateContext ctx) {
		 System.out.println("vibration...");
	}

}
