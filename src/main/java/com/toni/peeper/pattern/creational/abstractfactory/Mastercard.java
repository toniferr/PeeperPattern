package com.toni.peeper.pattern.creational.abstractfactory;

public class Mastercard implements Card{

	public String getCardNumber() {
		return "000 0 00 0000 00 MASTERCARD";
	}

	public String getCardType() {
		return "MASTERCARD";
	}

}
