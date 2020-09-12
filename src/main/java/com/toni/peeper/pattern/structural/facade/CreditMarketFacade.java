package com.toni.peeper.pattern.structural.facade;

public class CreditMarketFacade {

	private Credit gold;
	private Credit silver;
	private Credit black;
	
	public CreditMarketFacade() {
		gold = new Gold();
		silver = new Silver();
		black = new Black();
	}
	
	public void showCreditGold() {
		gold.showCredit();
	}
	
	public void showCreditSilver() {
		silver.showCredit();
	}
	
	public void showCreditBlack() {
		black.showCredit();
	}	
	
}
