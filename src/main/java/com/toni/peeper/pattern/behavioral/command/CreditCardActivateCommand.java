package com.toni.peeper.pattern.behavioral.command;

public class CreditCardActivateCommand implements Command{

	CreditCard creditCard;
	
	public CreditCardActivateCommand(CreditCard creditCard) {
		this.creditCard=creditCard;
	}

	public void execute() {
		creditCard.sendPinNumberToCustomer();
		creditCard.activate();
		creditCard.sendSMSNumberToCustomerActive();
	}
	
	
}
