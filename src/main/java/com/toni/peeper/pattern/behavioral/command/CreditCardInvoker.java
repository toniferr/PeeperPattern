package com.toni.peeper.pattern.behavioral.command;

public class CreditCardInvoker {
	
	private Command command;
	
	public CreditCardInvoker() {}
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void run() {
		command.execute();
	}

}
