package com.toni.peeper.pattern.structural.bridge;

public class SecureCreditCard implements ICreditCard {

	public void realizarPago() {
		System.out.println("Pago realizado CON SEGURIDAD");
	}

}
