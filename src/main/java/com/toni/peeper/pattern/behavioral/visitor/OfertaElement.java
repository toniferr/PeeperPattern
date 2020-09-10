package com.toni.peeper.pattern.behavioral.visitor;

public interface OfertaElement {

	void accept(CreditCardVisitor visitor);
}
