package com.toni.peeper.pattern.structural.flyweight;

import java.util.HashMap;

public class EnemyFactory {

	private static HashMap<String, Enemy> enemigos = new HashMap<String, Enemy>();

	public static Enemy getEnemy(String type) {
		Enemy enemigo = null;
		if (enemigos.containsKey(type)) {
			enemigo = enemigos.get(type);
		} else {
			if ("Private".equals(type)) {
				System.out.println("Soldado ha sido creado");
				enemigo = new Private();
			} else if ("Detective".equals(type)) {
				System.out.println("Detective ha sido creado");
				enemigo = new Detective();
			} else {
				System.out.println("No se ha creado enemigo");
			}
			enemigos.put(type, enemigo);
		}
		return enemigo;
	}
}
