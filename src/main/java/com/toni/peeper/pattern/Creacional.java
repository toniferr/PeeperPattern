package com.toni.peeper.pattern;

import com.toni.peeper.pattern.creational.abstractfactory.AbstractFactory;
import com.toni.peeper.pattern.creational.abstractfactory.Card;
import com.toni.peeper.pattern.creational.abstractfactory.FactoryProvider;
import com.toni.peeper.pattern.creational.abstractfactory.PaymentMethod;
import com.toni.peeper.pattern.creational.factorymethod.Payment;
import com.toni.peeper.pattern.creational.factorymethod.PaymentFactory;
import com.toni.peeper.pattern.creational.factorymethod.PaymentType;
import com.toni.peeper.pattern.creational.prototype.PrototypeCard;
import com.toni.peeper.pattern.creational.prototype.PrototypeFactory;
import com.toni.peeper.pattern.creational.prototype.PrototypeFactory.CardType;

public class Creacional {
	
	/********************FACTORY METHOD********************/
	static void testFactoryMethod() {
		Payment payment = PaymentFactory.buildPayment(PaymentType.DEBIT);
		payment.doPayment();
	}
	
	/********************ABSTRACT FACTORY********************/
	static void testAbstractFactory() {
		AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
		Card tarjeta = (Card)abstractFactory.create("VISA");
		
		AbstractFactory abstractFactory2 = FactoryProvider.getFactory("PaymentMethod");
		PaymentMethod paymentMethod = (PaymentMethod)abstractFactory2.create("DEBIT");
		
		System.out.println("Tarjeta de tipo: "+tarjeta.getCardType()+", con el m�todo de pago: "+paymentMethod.doPayment());
	}
	
	/********************BUILDER********************/
	static void testBuilder() {
		com.toni.peeper.pattern.creational.builder.Card card = new com.toni.peeper.pattern.creational.builder.Card.CardBuilder("VISA", "00 0 0000 0 0 VISA").name("Toni").expires(2030).credit(true).build();
		System.out.println(card);
		
		com.toni.peeper.pattern.creational.builder.Card card2 = new com.toni.peeper.pattern.creational.builder.Card.CardBuilder("MASTERCARD", "000 0 000 MASTERCARD").name("Antonio").expires(2028).credit(false).build();
		System.out.println(card2);
	}
	
	/********************PROTOTYPE********************/
	static void testPrototype() {
		PrototypeFactory.loadCard();
		try {
			PrototypeCard visa = PrototypeFactory.getInstance(CardType.VISA);
			visa.getCard();

			PrototypeCard amex = PrototypeFactory.getInstance(CardType.AMEX);
			amex.getCard();
			
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	/********************SINGLETON********************/
	static void testSingleton() {
		//com.toni.peeper.pattern.creational.singleton Card = new com.toni.peeper.pattern.creational.singleton.Card();  no se puede, es un constructor privado
		
		com.toni.peeper.pattern.creational.singleton.Card.getINSTANCE().setCardNumber("013413457345");
		System.out.println(com.toni.peeper.pattern.creational.singleton.Card.getINSTANCE().getCardNumber());
	}

}
