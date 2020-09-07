package com.toni.peeper.pattern.behavioral.mediator;

public class ConcreteColleage1 extends Colleage{

	public ConcreteColleage1(Mediator mediator) {
		super(mediator);
	}
	
	@Override
	public void send(String message) {
		mediator.send(message, this);
	}

	@Override
	public void messageReceive(String message) {
		System.out.println("Colleage1 ha recibido el siguiente mensaje: "+message);
	}

}
