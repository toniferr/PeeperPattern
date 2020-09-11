package com.toni.peeper.pattern.structural.bridge;

public class ClassicCreditCard extends CreditCard{

	public ClassicCreditCard(ICreditCard tarjeta) {
		super(tarjeta);
	}
	
	@Override
	public void realizarPago() {
		tarjeta.realizarPago();
	}

	
}
