package com.toni.peeper.pattern.creational.factorymethod;

public class PaymentFactory {
	
	public static Payment buildPayment(PaymentType paymentType) {
		switch (paymentType) {
			//se crean los objetos en la superclase
		    case CREDIT: return new CreditCard();
			case DEBIT: return new DebitCard();
			default: return new DebitCard();
		}
	};
}
