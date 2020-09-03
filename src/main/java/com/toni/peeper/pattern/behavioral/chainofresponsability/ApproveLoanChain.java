package com.toni.peeper.pattern.behavioral.chainofresponsability;

public interface ApproveLoanChain {
	
	void setNext(ApproveLoanChain loan);
	ApproveLoanChain getNext();
	void creditCardRequest(int totalLoan);

}
