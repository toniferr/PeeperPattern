package com.toni.peeper.pattern.behavioral.state;

public class Vibracion implements MobileAlertState{

	public void alert(MobileAlertStateContext context) {
		System.out.println("Vibrando..Vibrando..Vibrando..");
	}

}
