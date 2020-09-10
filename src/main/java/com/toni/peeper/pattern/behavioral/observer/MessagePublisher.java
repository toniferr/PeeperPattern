package com.toni.peeper.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject{

	private List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer o) {
		observers.add(o);
	}

	public void dettach(Observer o) {
		observers.remove(o);
	}

	public void notifyUpdate(Semaforo semaforo) {
		for( Observer o: observers) {
			o.update(semaforo);
		}
	}

	
}
