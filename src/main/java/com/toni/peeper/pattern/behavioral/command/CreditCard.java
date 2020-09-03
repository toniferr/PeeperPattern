package com.toni.peeper.pattern.behavioral.command;

public class CreditCard {
	
	public void sendPinNumberToCustomer() {
		System.out.println("El pin ha sido enviado al cliente");
	}
	
	public void sendSMSNumberToCustomerActive() {
		System.out.println("El sms ha sido enviado al cliente informando de tarjeta activada.");
	}
	
	public void activate() {
		System.out.println("La tarjeta ha sido activada");
	}
	
	public void desactivate() {
		System.out.println("La tarjeta ha sido desactivada");
	}
	
	public void sendSMSNumberToCustomerDesactive() {
		System.out.println("El sms ha sido enviado al cliente informando de tarjeta desactivada.");
	}
}
