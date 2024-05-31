package com.toni.peeper.pattern.structural.adapter;

public class Adapter implements Payment {

	Secure secureCreditCard;

	public Adapter(String type) {
		if ("black".equals(type)) {
			secureCreditCard = new BlackCreditCard();
		} else if ("gold".equals(type)) {
			secureCreditCard = new GoldCreditCard();
		}
	}

	public void pay(String type) {
		if ("black".equals(type)) {
			secureCreditCard.payWithSecureLevelA();
		} else if ("gold".equals(type)) {
			secureCreditCard.payWithSecureLevelZ();
		}
	}

}
