package com.toni.peeper.pattern.behavioral.visitor;

public interface CreditCardVisitor {

	void ofertaGasolina(OfertaGasolina ofertaGasolina);
	void ofertaVuelos(OfertaVuelos ofertaVuelos);
}
