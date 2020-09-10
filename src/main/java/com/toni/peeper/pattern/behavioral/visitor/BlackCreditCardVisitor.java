package com.toni.peeper.pattern.behavioral.visitor;

public class BlackCreditCardVisitor implements CreditCardVisitor{

	public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
		System.out.println("10% Oferta Gasolina con tarjeta black");
	}

	public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
		System.out.println("25% Oferta Vuelos con tarjeta de black");
	}

}
