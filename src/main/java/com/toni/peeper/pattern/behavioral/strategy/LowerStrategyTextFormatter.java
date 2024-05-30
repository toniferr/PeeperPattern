package com.toni.peeper.pattern.behavioral.strategy;

public class LowerStrategyTextFormatter implements StrategyTextFormatter {

	public void format(String text) {
		System.out.println("Texto en minúsculas:"+ text.toLowerCase());
	}

}
