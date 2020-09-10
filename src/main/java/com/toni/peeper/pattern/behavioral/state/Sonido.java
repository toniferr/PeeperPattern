package com.toni.peeper.pattern.behavioral.state;

public class Sonido  implements MobileAlertState{

	public void alert(MobileAlertStateContext context) {
		System.out.println("Sonando..Sonando..Sonando..");
	}

}
