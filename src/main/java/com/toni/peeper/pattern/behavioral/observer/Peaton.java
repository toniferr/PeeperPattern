package com.toni.peeper.pattern.behavioral.observer;

public class Peaton implements Observer{

	public void update(Semaforo semaforo) {
		if(semaforo.getStatus().equals("ROJO_COCHE")) {
			System.out.println("Semaforo Verde para Peaton: -> Peaton SI puede pasar");
		} else {
			System.out.println("Semaforo Rojo para Peaton: -> Peaton NO puede pasar");
		}
	}

}
