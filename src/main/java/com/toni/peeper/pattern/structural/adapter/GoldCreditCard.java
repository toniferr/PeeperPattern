package com.toni.peeper.pattern.structural.adapter;

public class GoldCreditCard implements Secure {

	public void payWithSecureLevelA() {
		//no implementar
	}

	public void payWithSecureLevelZ() {
		System.out.println("Tarjeta Gold: Pagando con Seguridad Baja nivel Z");
	}

}
