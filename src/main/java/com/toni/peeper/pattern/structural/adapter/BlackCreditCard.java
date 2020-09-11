package com.toni.peeper.pattern.structural.adapter;

public class BlackCreditCard implements Secure {

	public void payWithSecureLevelA() {
		System.out.println("Tarjeta Black: Pagando con Seguridad Alta nivel A");
	}

	public void payWithSecureLevelZ() {
		// no implementar
	}

}
