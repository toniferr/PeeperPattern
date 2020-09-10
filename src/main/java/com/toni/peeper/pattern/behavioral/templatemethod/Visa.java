package com.toni.peeper.pattern.behavioral.templatemethod;

public class Visa extends Payment{

	@Override
	void initialize() {
		System.out.println("Inicializando pago con Visa...");
	}

	@Override
	void startPayment() {
		System.out.println("Realizando pago con Visa...");
	}

	@Override
	void endPayment() {
		System.out.println("Finalizando pago con Visa...");
	}
}
