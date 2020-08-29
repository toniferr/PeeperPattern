package com.toni.peeper.pattern.creational.prototype;

public class Amex implements PrototypeCard{

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getCard() {
		System.out.println("Esto es una tarjeta Amex");
	}

	public PrototypeCard clone() throws CloneNotSupportedException {
		System.out.println("Clonando tarjeta amex...");
		return (Amex) super.clone();
	}

	
}
