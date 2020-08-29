package com.toni.peeper.pattern.creational.prototype;

public class Visa implements PrototypeCard{

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getCard() {
		System.out.println("Esto es una tarjeta Visa");
	}

	public PrototypeCard clone() throws CloneNotSupportedException {
		System.out.println("Clonando tarjeta visa...");
		return (Visa) super.clone();
	}

	
}
