package com.toni.peeper.pattern.behavioral.visitor;

public class ClassicCreditCardVisitor implements CreditCardVisitor {

	public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
		System.out.println("3% Oferta Gasolina con tarjeta de cr�dito");
	}

	public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
		System.out.println("5% Oferta Vuelos con tarjeta de cr�dito");
	}

}
