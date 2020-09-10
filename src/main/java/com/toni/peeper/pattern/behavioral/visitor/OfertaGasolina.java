package com.toni.peeper.pattern.behavioral.visitor;

public class OfertaGasolina implements OfertaElement {

	public void accept(CreditCardVisitor visitor) {
		visitor.ofertaGasolina(this);
	}

}
