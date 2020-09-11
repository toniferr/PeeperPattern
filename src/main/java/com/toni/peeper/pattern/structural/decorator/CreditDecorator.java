package com.toni.peeper.pattern.structural.decorator;

public class CreditDecorator implements Credit {

	protected Credit decoratedCredit;
		
	public CreditDecorator(Credit decoratedCredit) {
		this.decoratedCredit = decoratedCredit;
	}

	public void showCredit() {
		decoratedCredit.showCredit();
	}

}
