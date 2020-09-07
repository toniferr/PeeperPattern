package com.toni.peeper.pattern.behavioral.iterator;

public interface Iterator {

	boolean hasNext();
	
	Object next();
	
	Object currentItem();
	
}
