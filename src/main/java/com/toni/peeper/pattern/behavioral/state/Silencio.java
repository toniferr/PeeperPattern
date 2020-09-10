package com.toni.peeper.pattern.behavioral.state;

public class Silencio  implements MobileAlertState{

	public void alert(MobileAlertStateContext context) {
		System.out.println("Silencio...pantalla iluminada...");
	}

}
