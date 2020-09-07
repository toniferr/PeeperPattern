package com.toni.peeper.pattern.behavioral.mediator;

public abstract class Colleage {

	protected Mediator mediator;
	
	public Colleage(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public abstract void send(String message);
	public abstract void messageReceive(String message);
}
