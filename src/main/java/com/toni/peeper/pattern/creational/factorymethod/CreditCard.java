package com.toni.peeper.pattern.creational.factorymethod;

public class CreditCard implements Payment{

	public void doPayment() {
		System.out.println("Pago realizado con tarjeta de crédito");
	}

}
