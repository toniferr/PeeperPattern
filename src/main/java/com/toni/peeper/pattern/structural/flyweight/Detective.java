package com.toni.peeper.pattern.structural.flyweight;

public class Detective implements Enemy {

    private final String LIFE;

	public Detective() {
		LIFE = "1000";
	}

	public void setWeapon(String weapon) {
        System.out.println("El arma del soldado es: "+ weapon);
	}

	public void lifePoints() {
		System.out.println("La vida de un teniente es: "+ LIFE);
	}
}
