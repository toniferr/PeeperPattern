package com.toni.peeper.pattern.behavioral.chainofresponsability;

public class Tarjeta implements ApproveLoanChain{

	private ApproveLoanChain next;
	
	public void setNext(ApproveLoanChain loan) {
		next = loan;
	}

	public ApproveLoanChain getNext() {
		return next;
	}

	public void creditCardRequest(int totalLoan) {
		Gold gold = new Gold();
		this.setNext(gold);
		
		Platinium platinium = new Platinium();
		gold.setNext(platinium);
		
		Black black = new Black();
		platinium.setNext(black);
		
		next.creditCardRequest(totalLoan);
	}

}
