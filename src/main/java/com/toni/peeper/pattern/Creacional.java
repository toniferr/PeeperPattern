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

	/********************SINGLETON********************/
	static void testSingleton() {
		//com.toni.peeper.pattern.creational.singleton Card = new com.toni.peeper.pattern.creational.singleton.Card();  no se puede, es un constructor privado
		System.out.println("######################################");
		System.out.println("Patrón de diseño SINGLETON");
		System.out.println("######################################");

		System.out.println("Inicializo objeto card1 con instancia de Card");
		com.toni.peeper.pattern.creational.singleton.Card card1 =  com.toni.peeper.pattern.creational.singleton.Card.getInstance();
		System.out.println("Seteo numero de tarjeta 013413457345");
		card1.setCardNumber("013413457345");
		System.out.println(card1.getCardNumber());
		System.out.println("Inicializo objeto card2 con instancia de Card pero no seteo numero de tarjeta");
		com.toni.peeper.pattern.creational.singleton.Card card2 =  com.toni.peeper.pattern.creational.singleton.Card.getInstance();
		System.out.println(card2.getCardNumber());
		System.out.println("Seteo numero de tarjeta 017772782 a card2 y veo numero de tarjeta de ambas card1 y card2");
		card2.setCardNumber("017772782");
		System.out.println(card1.getCardNumber());
		System.out.println(card2.getCardNumber());
	}

	/********************BUILDER********************/
	static void testBuilder() {
		System.out.println("######################################");
		System.out.println("Patrón de diseño BUILDER");
		System.out.println("######################################");

		System.out.println("Construir card1 con builder");
		com.toni.peeper.pattern.creational.builder.Card card1 = new com.toni.peeper.pattern.creational.builder.Card
				.CardBuilder("VISA", "00 0 0000 0 0 VISA")
				.name("Toni")
				.expires(2030)
				.credit(true)
				.build();
		System.out.println(card1);

		System.out.println("Construir card2 con builder");
		com.toni.peeper.pattern.creational.builder.Card card2 = new com.toni.peeper.pattern.creational.builder.Card
				.CardBuilder("MASTERCARD", "000 0 000 MASTERCARD")
				.name("Antonio")
				.expires(2028)
				.credit(false)
				.build();
		System.out.println(card2);
	}

	/********************FACTORY METHOD********************/
	static void testFactoryMethod() {
		System.out.println("######################################");
		System.out.println("Patrón de diseño FACTORY METHOD");
		System.out.println("######################################");

		System.out.println("Inicializo interfaz con metodo del Factory tipo Debito");
		Payment payment = PaymentFactory.buildPayment(PaymentType.DEBIT);
		System.out.println("Llamo a doPayment override del objeto que implementa la interfaz");
		payment.doPayment();
	}
	
	/********************ABSTRACT FACTORY********************/
	static void testAbstractFactory() {
		System.out.println("######################################");
		System.out.println("Patrón de diseño ABSTRACT FACTORY");
		System.out.println("######################################");

		System.out.println("Creación tarjeta visa con factoria abstracta");
		AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
		Card tarjeta = (Card)abstractFactory.create("VISA");


		System.out.println("Creación metodo de pago debito con factoria abstracta");
		AbstractFactory abstractFactory2 = FactoryProvider.getFactory("PaymentMethod");
		PaymentMethod paymentMethod = (PaymentMethod)abstractFactory2.create("DEBIT");
		
		System.out.println("Tarjeta de tipo: "+tarjeta.getCardType()+", con el método de pago: "+paymentMethod.doPayment());
	}
	
	/********************PROTOTYPE********************/
	static void testPrototype() {
		System.out.println("######################################");
		System.out.println("Patrón de diseño PROTOTYPE");
		System.out.println("######################################");
		
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


}
