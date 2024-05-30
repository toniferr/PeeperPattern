package com.toni.peeper.pattern.creational.factorymethod;

public class DebitCard implements Payment {

	public void doPayment() {
		System.out.println("Pago realizado con tarjeta de débito");
	}

}
