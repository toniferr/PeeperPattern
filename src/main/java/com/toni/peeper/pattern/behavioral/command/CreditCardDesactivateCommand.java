package com.toni.peeper.pattern.behavioral.command;

public class CreditCardDesactivateCommand implements Command{

	CreditCard creditCard;
	
	public CreditCardDesactivateCommand(CreditCard creditCard) {
		this.creditCard=creditCard;
	}

	public void execute() {
		creditCard.desactivate();
		creditCard.sendSMSNumberToCustomerDesactive();
	}
	
	
}
