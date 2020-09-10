package com.toni.peeper.pattern.behavioral.state;

public class MobileAlertStateContext {

	private MobileAlertState currentState;
	
	public MobileAlertStateContext() {
		currentState = new Sonido();
	}
	
	public void setState(MobileAlertState state) {
		currentState = state;
	}
	
	public void alert() {
		currentState.alert(this);
	}
}
