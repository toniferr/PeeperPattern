package com.toni.peeper.pattern.creational.abstractfactory;

public class Debit implements PaymentMethod {

	public String doPayment() {
		return "Pago a débito";
	}

}
