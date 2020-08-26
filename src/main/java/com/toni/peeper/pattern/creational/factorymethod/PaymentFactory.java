package com.toni.peeper.pattern.creational.factorymethod;

public class PaymentFactory {
	
	public static Payment buildPayment(PaymentType paymentType) {
		switch (paymentType) {
		case CREDIT: return new CreditCard();
		case DEBIT: return new DebitCard();
		default: return new DebitCard();
		}
	};
}
