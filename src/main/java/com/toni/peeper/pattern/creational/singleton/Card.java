package com.toni.peeper.pattern.creational.singleton;

public class Card {
	
	private static Card instance;
	
	private String cardNumber;
	
	private Card() {}
	
	public static Card getInstance() {
		if (instance == null) {
			instance = new Card();
		}
		return instance;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}	
	
}
