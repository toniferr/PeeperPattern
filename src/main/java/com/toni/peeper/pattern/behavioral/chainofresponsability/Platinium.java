package com.toni.peeper.pattern.behavioral.chainofresponsability;

public class Platinium implements ApproveLoanChain{
	
	private ApproveLoanChain next;

	public void setNext(ApproveLoanChain loan) {
		next = loan;		
	}

	public ApproveLoanChain getNext() {
		return next;
	}

	public void creditCardRequest(int totalLoan) {
		if (totalLoan > 10000 && totalLoan <= 50000) {
			System.out.println("Esta solicitud de crédito la maneja la tarjeta Black");
		} else {
			next.creditCardRequest(totalLoan);
		}
	}

}
