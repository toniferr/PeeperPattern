package com.toni.peeper.pattern.structural.decorator;

public class SecureDecorator extends CreditDecorator{

	public SecureDecorator(Credit decoratedCredit) {
		super(decoratedCredit);
	}


	public void showCredit() {
		decoratedCredit.showCredit();
		configSecurePayment();
	}
	
	private void configSecurePayment() {
		System.out.println("La tarjeta ha sido configurada para hacer pagos seguros");
	}

}
