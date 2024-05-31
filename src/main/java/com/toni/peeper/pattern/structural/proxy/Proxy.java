package com.toni.peeper.pattern.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class Proxy implements Internet{

	private Internet internet = new AccessToInternet();
	private static List<String> bannedUrl;
	
	static {
		bannedUrl = new ArrayList<String>();
		bannedUrl.add("twitter.com");
		bannedUrl.add("facebook.com");
		bannedUrl.add("google.com");
	}
	
	public void connectTo(String url) throws Exception {
		if (bannedUrl.contains(url)) {
			throw new Exception("URL "+url+" bloqueada - Acceso Denegado");
		} 
		internet.connectTo(url);
	}

}
