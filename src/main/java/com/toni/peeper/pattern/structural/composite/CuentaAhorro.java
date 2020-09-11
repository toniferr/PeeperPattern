package com.toni.peeper.pattern.structural.composite;

public class CuentaAhorro implements CuentaComponent {

	private Double amount;
	
	private String name;
	
	
	public CuentaAhorro(Double amount, String name) {
		this.amount = amount;
		this.name = name;
	}

	public void showAccountName() {
		System.out.println("Cuenta ahorro: "+ name);
	}

	public Double getAmount() {
		return amount;
	}

}
