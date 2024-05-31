package com.toni.peeper.pattern;

import java.util.Random;

import com.toni.peeper.pattern.structural.bridge.ClassicCreditCard;
import com.toni.peeper.pattern.structural.bridge.SecureCreditCard;
import com.toni.peeper.pattern.structural.bridge.UnsecureCreditCard;
import com.toni.peeper.pattern.structural.composite.CuentaAhorro;
import com.toni.peeper.pattern.structural.composite.CuentaComponent;
import com.toni.peeper.pattern.structural.composite.CuentaComposite;
import com.toni.peeper.pattern.structural.composite.CuentaCorriente;
import com.toni.peeper.pattern.structural.decorator.Black;
import com.toni.peeper.pattern.structural.decorator.Credit;
import com.toni.peeper.pattern.structural.decorator.Gold;
import com.toni.peeper.pattern.structural.decorator.InternationalPaymentDecorator;
import com.toni.peeper.pattern.structural.decorator.SecureDecorator;
import com.toni.peeper.pattern.structural.facade.CreditMarketFacade;
import com.toni.peeper.pattern.structural.flyweight.Enemy;
import com.toni.peeper.pattern.structural.flyweight.EnemyFactory;
import com.toni.peeper.pattern.structural.proxy.Internet;
import com.toni.peeper.pattern.structural.proxy.Proxy;

public class Structural {

	/********************FACADE********************/
	static void testFacade() {
		System.out.println("######################################");
		System.out.println("Patrón de diseño FACADE");
		System.out.println("######################################");

		CreditMarketFacade creditMarket = new CreditMarketFacade();
		creditMarket.showCreditBlack();
		creditMarket.showCreditSilver();
		creditMarket.showCreditGold();
	}

	/********************DECORATOR********************/
	static void testDecorator() {
		System.out.println("######################################");
		System.out.println("Patrón de diseño DECORATOR");
		System.out.println("######################################");


		System.out.println("Creo gold componente concreto");
		com.toni.peeper.pattern.structural.decorator.Credit gold = new Gold();

		System.out.println("Creo black international payment componente concreto");
		com.toni.peeper.pattern.structural.decorator.Credit blackInternationalPayment = new Black();
		blackInternationalPayment = new InternationalPaymentDecorator(blackInternationalPayment);

		System.out.println("Creo gold secure payment componente concreto");
		com.toni.peeper.pattern.structural.decorator.Credit goldSecureInternational = new Gold();
		goldSecureInternational = new InternationalPaymentDecorator(goldSecureInternational);
		goldSecureInternational = new SecureDecorator(goldSecureInternational);

		System.out.println("---Tarjeta Gold sin decorator---");
		gold.showCredit();

		System.out.println("---Tarjeta black con decorator international payment---");
		blackInternationalPayment.showCredit();

		System.out.println("---Tarjeta Gold2 con decorator secure y decorator international payment---");
		goldSecureInternational.showCredit();
	}

	/********************ADAPTER********************/
	static void testAdapter() {
		System.out.println("######################################");
		System.out.println("Patrón de diseño DECORATOR");
		System.out.println("######################################");

		com.toni.peeper.pattern.structural.adapter.CreditCard creditCard =
				new com.toni.peeper.pattern.structural.adapter.CreditCard();
		creditCard.pay("classic");
		creditCard.pay("gold");
		creditCard.pay("black");
		creditCard.pay("silver");
	}

	/********************PROXY********************/
	static void testProxy()	{
		System.out.println("######################################");
		System.out.println("Patrón de diseño PROXY");
		System.out.println("######################################");

		Internet internet = new Proxy();
		try {
			internet.connectTo("udemy.com");
			internet.connectTo("twitter.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/********************BRIDGE********************/
	static void testBridge() {
		com.toni.peeper.pattern.structural.bridge.CreditCard classic = new ClassicCreditCard(new UnsecureCreditCard());
		classic.realizarPago();
		
		classic = new ClassicCreditCard(new SecureCreditCard());
		classic.realizarPago();
	}
	
	/********************COMPOSITE********************/
	static void testComposite() {
		CuentaComponent cuentaCorriente = new CuentaCorriente(1000.0, "Toni");
		CuentaComponent cuentaAhorro = new CuentaAhorro( 20000.0, "Toni");
		
		CuentaComposite cuentaComposite = new CuentaComposite();
		cuentaComposite.addCuenta(cuentaCorriente);
		cuentaComposite.addCuenta(cuentaAhorro);
		
		cuentaComposite.showAccountName();
		cuentaComposite.getAmount();
	}
	
	/********************FLYWEIGHT********************/
	static void testFlyweight() {
		for(int i=0; i<15; i++) {
			Enemy enemy = EnemyFactory.getEnemy(getRandomEnemyType());
			enemy.setWeapon(getRandomWeapon());
			enemy.lifePoints();
		}
	}
	
	static String getRandomEnemyType() {
		Random r = new Random();
		int randInt = r.nextInt(enemyType.length);
		return enemyType[randInt];
	}
	
	static String getRandomWeapon() {
		Random r = new Random();
		int randInt = r.nextInt(weapon.length);
		return weapon[randInt];
	}
	
	private static String[] enemyType = {"Private", "Detective"};
	private static String[] weapon = {"Fusil", "Revolver", "Pistola", "Metralleta", "Lanza Granadas"};

}
