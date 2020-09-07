package com.toni.peeper.pattern;

import com.toni.peeper.pattern.behavioral.chainofresponsability.Tarjeta;
import com.toni.peeper.pattern.behavioral.command.CreditCard;
import com.toni.peeper.pattern.behavioral.command.CreditCardActivateCommand;
import com.toni.peeper.pattern.behavioral.command.CreditCardDesactivateCommand;
import com.toni.peeper.pattern.behavioral.command.CreditCardInvoker;
import com.toni.peeper.pattern.behavioral.iterator.CardList;
import com.toni.peeper.pattern.behavioral.iterator.Iterator;
import com.toni.peeper.pattern.behavioral.mediator.ConcreteColleage1;
import com.toni.peeper.pattern.behavioral.mediator.ConcreteColleage2;
import com.toni.peeper.pattern.behavioral.mediator.ConcreteMediator;
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

public class PeeperPattern {

	public static void main(String[] args) {
		
		
		/********************CREACIONAL********************/
//		testFactoryMethod();
//		testAbstractFactory();
//		testBuilder();
//		testPrototype();
//		testSingleton();
		/********************\/CREACIONAL*******************/
		
		
		/********************COMPORTAMIENTO********************/
//		testChainOfResponsability(1000);
//		testCommand();
//		testIterator();
		testMediator();
		/********************\/COMPORTAMIENTO*******************/
	}

	
	/********************CREACIONAL********************/
	private static void testFactoryMethod() {
		Payment payment = PaymentFactory.buildPayment(PaymentType.DEBIT);
		payment.doPayment();
	}
	
	private static void testAbstractFactory() {
		AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
		Card tarjeta = (Card)abstractFactory.create("VISA");
		
		AbstractFactory abstractFactory2 = FactoryProvider.getFactory("PaymentMethod");
		PaymentMethod paymentMethod = (PaymentMethod)abstractFactory2.create("DEBIT");
		
		System.out.println("Tarjeta de tipo: "+tarjeta.getCardType()+", con el m�todo de pago: "+paymentMethod.doPayment());
	}
	
	private static void testBuilder() {
		com.toni.peeper.pattern.creational.builder.Card card = new com.toni.peeper.pattern.creational.builder.Card.CardBuilder("VISA", "00 0 0000 0 0 VISA").name("Toni").expires(2030).credit(true).build();
		System.out.println(card);
		
		com.toni.peeper.pattern.creational.builder.Card card2 = new com.toni.peeper.pattern.creational.builder.Card.CardBuilder("MASTERCARD", "000 0 000 MASTERCARD").name("Antonio").expires(2028).credit(false).build();
		System.out.println(card2);
	}
	
	private static void testPrototype() {
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
	
	private static void testSingleton() {
		//com.toni.peeper.pattern.creational.singleton Card = new com.toni.peeper.pattern.creational.singleton.Card();  no se puede, es un constructor privado
		
		com.toni.peeper.pattern.creational.singleton.Card.getINSTANCE().setCardNumber("013413457345");
		System.out.println(com.toni.peeper.pattern.creational.singleton.Card.getINSTANCE().getCardNumber());
	}
	/********************\/CREACIONAL*******************/
	
	
	/********************COMPORTAMIENTO********************/
	private static void testChainOfResponsability(int loan) {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.creditCardRequest(loan);
	}
	
	private static void testCommand() {
		CreditCard creditCard = new CreditCard();
		CreditCard creditCardDesactivate = new CreditCard();
		
		CreditCardInvoker invoker = new CreditCardInvoker();
		
		invoker.setCommand(new CreditCardActivateCommand(creditCard));
		invoker.run();
		System.out.println("---------------------");
		
		invoker.setCommand(new CreditCardDesactivateCommand(creditCardDesactivate));
		invoker.run();
		
	}
	
	private static void testIterator() {
		com.toni.peeper.pattern.behavioral.iterator.Card[] cards = new com.toni.peeper.pattern.behavioral.iterator.Card[5];
		cards[0] = new com.toni.peeper.pattern.behavioral.iterator.Card("VISA");
		cards[1] = new com.toni.peeper.pattern.behavioral.iterator.Card("AMEX");
		cards[2] = new com.toni.peeper.pattern.behavioral.iterator.Card("MASTER CARD");
		cards[3] = new com.toni.peeper.pattern.behavioral.iterator.Card("GOOGLE CARD");
		cards[4] = new com.toni.peeper.pattern.behavioral.iterator.Card("APPLE CARD");
		
		com.toni.peeper.pattern.behavioral.iterator.List lista = new CardList(cards);
		Iterator iterator = lista.iterator();
		
		while (iterator.hasNext()) {
			com.toni.peeper.pattern.behavioral.iterator.Card tarjeta = (com.toni.peeper.pattern.behavioral.iterator.Card) iterator.next();
			System.out.println(tarjeta.getType());
		}
	}
	
	private static void testMediator() {
		ConcreteMediator mediator = new ConcreteMediator();
		ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
		ConcreteColleage2 user2 = new ConcreteColleage2(mediator);
		
		mediator.setUser1(user1);
		mediator.setUser2(user2);
		
		user1.send("Hola soy user1");
		user2.send("Hola user1, soy user2");
	}
	/********************\/COMPORTAMIENTO*******************/
}
