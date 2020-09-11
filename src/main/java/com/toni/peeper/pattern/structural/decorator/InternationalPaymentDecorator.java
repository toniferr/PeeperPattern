package com.toni.peeper.pattern.structural.decorator;

public class InternationalPaymentDecorator extends CreditDecorator{

	public InternationalPaymentDecorator(Credit decoratedCredit) {
		super(decoratedCredit);
	}


	public void showCredit() {
		decoratedCredit.showCredit();
		configInternationalPayment();
	}
	
	private void configInternationalPayment() {
		System.out.println("La tarjeta ha sido configurada para hacer pagos internacionales");
	}
}
