package com.toni.peeper.pattern.behavioral.chainofresponsability;

public class Gold implements ApproveLoanChain{
	
	private ApproveLoanChain next;

	public void setNext(ApproveLoanChain loan) {
		next = loan;		
	}

	public ApproveLoanChain getNext() {
		return next;
	}

	public void creditCardRequest(int totalLoan) {
		if (totalLoan <= 10000) {
			System.out.println("Esta solicitud de crédito la maneja la tarjeta Gold");
		} else {
			next.creditCardRequest(totalLoan);
		}
	}

}
