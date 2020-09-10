package com.toni.peeper.pattern.behavioral.interpreter;

public class TerminalExpression implements Expression {

	private String text;
	
	
	public TerminalExpression(String text) {
		super();
		this.text = text;
	}


	public boolean interpret(String context) {
		if(context.contains(text)) {
			return true;
		}
		return false;
	}

}
