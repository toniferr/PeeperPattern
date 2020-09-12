package com.toni.peeper.pattern.structural.proxy;

public class AccessToInternet implements Internet {

	public void connectTo(String url) throws Exception {
		System.out.println("Conectando a: "+url);
	}

}
