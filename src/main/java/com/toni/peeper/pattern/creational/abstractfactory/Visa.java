package com.toni.peeper.pattern.creational.abstractfactory;

public class Visa implements Card{

	public String getCardNumber() {
		return "0000 0000 000 VISA";
	}

	public String getCardType() {
		return "VISA";
	}

}
