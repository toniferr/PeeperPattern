package com.toni.peeper.pattern.behavioral.strategy;

public class CapitalStrategyTextFormatter implements StrategyTextFormatter {

	public void format(String text) {
		System.out.println("Texto en mayúsculas: "+text.toUpperCase());
	}

}
