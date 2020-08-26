package com.toni.peeper.pattern.creational.abstractfactory;

public class Credit implements PaymentMethod {

	public String doPayment() {
		return "Pago a crédito";
	}

}
