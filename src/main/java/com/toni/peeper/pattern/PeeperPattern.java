package com.toni.peeper.pattern;

import com.toni.peeper.pattern.creational.abstractfactory.AbstractFactory;
import com.toni.peeper.pattern.creational.abstractfactory.Card;
import com.toni.peeper.pattern.creational.abstractfactory.FactoryProvider;
import com.toni.peeper.pattern.creational.abstractfactory.PaymentMethod;
import com.toni.peeper.pattern.creational.factorymethod.Payment;
import com.toni.peeper.pattern.creational.factorymethod.PaymentFactory;
import com.toni.peeper.pattern.creational.factorymethod.PaymentType;

public class PeeperPattern {

	public static void main(String[] args) {
//		testFactoryMethod();
//		testAbstractFactory();
		testBuilder();
	}

	private static void testFactoryMethod() {
		Payment payment = PaymentFactory.buildPayment(PaymentType.DEBIT);
		payment.doPayment();
	}
	
	private static void testAbstractFactory() {
		AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
		Card tarjeta = (Card)abstractFactory.create("VISA");
		
		AbstractFactory abstractFactory2 = FactoryProvider.getFactory("PaymentMethod");
		PaymentMethod paymentMethod = (PaymentMethod)abstractFactory2.create("DEBIT");
		
		System.out.println("Tarjeta de tipo: "+tarjeta.getCardType()+", con el método de pago: "+paymentMethod.doPayment());
	}
	
	private static void testBuilder() {
		com.toni.peeper.pattern.creational.builder.Card card = new com.toni.peeper.pattern.creational.builder.Card.CardBuilder("VISA", "00 0 0000 0 0 VISA").name("Toni").expires(2030).credit(true).build();
		System.out.println(card);
		
		com.toni.peeper.pattern.creational.builder.Card card2 = new com.toni.peeper.pattern.creational.builder.Card.CardBuilder("MASTERCARD", "000 0 000 MASTERCARD").name("Antonio").expires(2028).credit(false).build();
		System.out.println(card2);
	}
}
