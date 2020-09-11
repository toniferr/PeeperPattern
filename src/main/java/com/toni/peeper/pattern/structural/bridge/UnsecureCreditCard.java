package com.toni.peeper.pattern.structural.bridge;

public class UnsecureCreditCard implements ICreditCard {

	public void realizarPago() {
		System.out.println("Pago realizado SIN SEGURIDAD");
	}

}
