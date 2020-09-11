package com.toni.peeper.pattern.structural.composite;

public class CuentaCorriente implements CuentaComponent {


	private Double amount;
	
	private String name;
	
	
	public CuentaCorriente(Double amount, String name) {
		this.amount = amount;
		this.name = name;
	}

	public void showAccountName() {
		System.out.println("Cuenta corriente: "+ name);
	}

	public Double getAmount() {
		return amount;
	}


}
