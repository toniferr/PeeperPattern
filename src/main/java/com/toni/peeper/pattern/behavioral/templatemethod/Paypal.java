package com.toni.peeper.pattern.behavioral.templatemethod;

public class Paypal extends Payment{

	@Override
	void initialize() {
		System.out.println("Inicializando pago con Paypal...");
	}

	@Override
	void startPayment() {
		System.out.println("Realizando pago con Paypal...");
	}

	@Override
	void endPayment() {
		System.out.println("Finalizando pago con Paypal...");
	}

}
