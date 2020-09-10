package com.toni.peeper.pattern.behavioral.visitor;

public class OfertaVuelos implements OfertaElement {

	public void accept(CreditCardVisitor visitor) {
		visitor.ofertaVuelos(this);
	}

}
