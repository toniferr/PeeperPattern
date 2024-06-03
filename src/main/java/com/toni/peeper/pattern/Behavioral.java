package com.toni.peeper.pattern;

import com.toni.peeper.pattern.behavioral.chainofresponsability.Tarjeta;
import com.toni.peeper.pattern.behavioral.command.CreditCard;
import com.toni.peeper.pattern.behavioral.command.CreditCardActivateCommand;
import com.toni.peeper.pattern.behavioral.command.CreditCardDesactivateCommand;
import com.toni.peeper.pattern.behavioral.command.CreditCardInvoker;
import com.toni.peeper.pattern.behavioral.interpreter.AndExpression;
import com.toni.peeper.pattern.behavioral.interpreter.Expression;
import com.toni.peeper.pattern.behavioral.interpreter.OrExpression;
import com.toni.peeper.pattern.behavioral.interpreter.TerminalExpression;
import com.toni.peeper.pattern.behavioral.iterator.CardList;
import com.toni.peeper.pattern.behavioral.iterator.Iterator;
import com.toni.peeper.pattern.behavioral.mediator.ConcreteColleage1;
import com.toni.peeper.pattern.behavioral.mediator.ConcreteColleage2;
import com.toni.peeper.pattern.behavioral.mediator.ConcreteMediator;
import com.toni.peeper.pattern.behavioral.memento.Article;
import com.toni.peeper.pattern.behavioral.memento.ArticleMemento;
import com.toni.peeper.pattern.behavioral.memento.Carataker;
import com.toni.peeper.pattern.behavioral.observer.Coche;
import com.toni.peeper.pattern.behavioral.observer.MessagePublisher;
import com.toni.peeper.pattern.behavioral.observer.Peaton;
import com.toni.peeper.pattern.behavioral.observer.Semaforo;
import com.toni.peeper.pattern.behavioral.state.MobileAlertStateContext;
import com.toni.peeper.pattern.behavioral.state.Silencio;
import com.toni.peeper.pattern.behavioral.state.Vibracion;
import com.toni.peeper.pattern.behavioral.strategy.CapitalStrategyTextFormatter;
import com.toni.peeper.pattern.behavioral.strategy.Context;
import com.toni.peeper.pattern.behavioral.strategy.LowerStrategyTextFormatter;
import com.toni.peeper.pattern.behavioral.templatemethod.Paypal;
import com.toni.peeper.pattern.behavioral.templatemethod.Visa;
import com.toni.peeper.pattern.behavioral.visitor.BlackCreditCardVisitor;
import com.toni.peeper.pattern.behavioral.visitor.ClassicCreditCardVisitor;
import com.toni.peeper.pattern.behavioral.visitor.OfertaElement;
import com.toni.peeper.pattern.behavioral.visitor.OfertaGasolina;
import com.toni.peeper.pattern.behavioral.visitor.OfertaVuelos;

public class Behavioral {

	/********************OBSERVER********************/
	static void testObserver() {
		System.out.println("######################################");
		System.out.println("Patrón de diseño OBSERVER");
		System.out.println("######################################");
		
		Coche coche = new Coche();
		Peaton peaton = new Peaton();

		MessagePublisher messagePublisher = new MessagePublisher();

		messagePublisher.attach(coche);
		messagePublisher.attach(peaton);
		messagePublisher.notifyUpdate(new Semaforo("ROJO_COCHE"));

		try {
			Thread.sleep(2000);
		}catch(Exception e) {

		}
		messagePublisher.notifyUpdate(new Semaforo("VERDE_COCHE"));
	}

	/********************CHAIN OF RESPONSABILITY********************/
	static void testChainOfResponsability(int loan) {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.creditCardRequest(loan);
	}
	
	/********************COMMAND********************/
	static void testCommand() {
		CreditCard creditCard = new CreditCard();
		CreditCard creditCardDesactivate = new CreditCard();
		
		CreditCardInvoker invoker = new CreditCardInvoker();
		
		invoker.setCommand(new CreditCardActivateCommand(creditCard));
		invoker.run();
		System.out.println("---------------------");
		
		invoker.setCommand(new CreditCardDesactivateCommand(creditCardDesactivate));
		invoker.run();
		
	}
	
	/********************ITERATOR********************/
	static void testIterator() {
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
	
	/********************MEDIATOR********************/
	static void testMediator() {
		ConcreteMediator mediator = new ConcreteMediator();
		ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
		ConcreteColleage2 user2 = new ConcreteColleage2(mediator);
		
		mediator.setUser1(user1);
		mediator.setUser2(user2);
		
		user1.send("Hola soy user1");
		user2.send("Hola user1, soy user2");
	}
	
	/********************MEMENTO********************/
	static void testMemento() {
		
		Carataker carataker = new Carataker();
		
		Article article = new Article("Toni","texto de articulo de pelicula");
		article.setText(article.getText()+" de Nolan");
		System.out.println(article.getText());
		
		carataker.addMemento(article.createMemento());
		article.setText(article.getText()+ "protagonizada por Guy Pearce");
		System.out.println(article.getText());
		
		carataker.addMemento(article.createMemento());
		
		article.setText(article.getText()+ " y Leonardo DiCaprio");
		System.out.println(article.getText());
		
		ArticleMemento memento1 = carataker.getmemento(0);
		ArticleMemento memento2 = carataker.getmemento(1);
		
		article.restoreMemento(memento1);
		System.out.println(article.getText());
		
		article.restoreMemento(memento2);
		System.out.println(article.getText());
		
		article.setText(article.getText()+ "del año 2000");
		System.out.println(article.getText());
		
	}
	
	/********************STATE********************/
	static void testState() {
		MobileAlertStateContext context = new MobileAlertStateContext();	
		context.alert();
		context.alert();
		
		context.setState(new Vibracion());
		context.alert();
		context.alert();
		
		context.setState(new Silencio());
		context.alert();
		context.alert();
	}
	
	/********************INTERPRETER********************/
	static void testInterpreter() {
		Expression cero = new TerminalExpression("0");
		Expression uno = new TerminalExpression("1");
		
		Expression contieneBoolean = new OrExpression(cero, uno);
		Expression contieneUnoOCero = new AndExpression(cero, uno);
		
		System.out.println(contieneBoolean.interpret("cero"));
		System.out.println(contieneBoolean.interpret("0"));
		System.out.println(contieneUnoOCero.interpret("cero"));
		System.out.println(contieneUnoOCero.interpret("0"));
		System.out.println(contieneUnoOCero.interpret("0,1"));
	}
	
	/********************STRATEGY********************/
	static void testStrategy() {
		Context context = new Context(new CapitalStrategyTextFormatter());
		context.publishText("Este texto será convertido a mayúsculas");
		
		context = new Context(new LowerStrategyTextFormatter());
		context.publishText("Este teXTO SERÁ CONVERTIDO A MINÚSCULAS");
		
		
	}
	
	/********************TEMPLATE METHOD********************/
	static void testTemplateMethod(){
		com.toni.peeper.pattern.behavioral.templatemethod.Payment payment = new Visa();
		payment.makePayment();
		
		payment = new Paypal();
		payment.makePayment();
	}
	
	/********************VISITOR********************/
	static void testVisitor() {
		OfertaElement ofertaElement = new OfertaGasolina();
		ofertaElement.accept(new BlackCreditCardVisitor());
		
		ofertaElement = new OfertaVuelos();
		ofertaElement.accept(new ClassicCreditCardVisitor());
	}
	
}
