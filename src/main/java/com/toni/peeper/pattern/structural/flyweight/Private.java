package com.toni.peeper.pattern.structural.flyweight;

public class Private implements Enemy {

	private String weapon;
	private final String LIFE;
	
	
	
	public Private() {
		LIFE = "200";
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
		System.out.println("El arma del soldado es: "+ weapon);
	}

	public void lifePoints() {
		System.out.println("La vida de un soldado es: "+ LIFE);
	}

}
